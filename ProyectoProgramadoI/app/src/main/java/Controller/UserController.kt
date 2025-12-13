package Controller

import Data.IDataManagerUser
import Data.MemoryDataManager
import Entity.DTOUser
import Entity.PasswordRequest
import Entity.PhoneRequest
import Entity.User
import Util.SOSAPIService
import Util.Util
import android.content.Context
import android.util.Log
import com.example.proyectoprogramadoi.R
import java.time.LocalDate

class UserController {
    private var dataManager: IDataManagerUser = MemoryDataManager
    private lateinit var context: Context

    constructor(context: Context){
        this.context=context
    }

    /*
    fun addU(user: User){
        try {
            dataManager.addUser(user)
        }catch (e: Exception){
            throw Exception(context.getString(R.string.ErrorMsgAddU))
        }
    }

    fun updatePass(context: Context, username: String, newPassword: String){
        try {
            dataManager.updatePassword(context, username, newPassword)
        }catch (e: Exception){
            throw Exception(context.getString(R.string.ErrorMsgUpdPass))
        }
    }

    fun getByUsername(username:String): User?{
        try {
            return dataManager.getByUsername(username)
        }catch (e: Exception){
            throw Exception(context.getString(R.string.ErrorMsgGetByUser))
        }
    }

    fun getByEmail(email: String): User?{
        try {
            return dataManager.getByEmail(email)
        }catch (e: Exception){
            throw Exception(context.getString(R.string.ErrorMsgGetByEmail))
        }
    }

    fun changePassword(user: User, password: String){
        try {
            dataManager.changePassword(user, password)
        }catch (e: Exception){
            throw Exception("Error ${e}")
        }
    }

    fun changePhone(user: User, phone: String){
        try {
            dataManager.changePhone(user, phone)
        }catch (e: Exception){
            throw Exception("Error ${e}")
        }
    }
    */




    //----------------------------------------------------------------------------------
    //Logica de implementacion de la API
    //----------------------------------------------------------------------------------
    suspend fun addU(user: User){
        try {
            val response = SOSAPIService.apiUser.postUser(convertToDTOUserObject(user))
            if (response.responseCode != 200)
                throw Exception(response.message)

        }catch (e: Exception){
            Log.e("API_Call", "Error fetching data: ${e.message}")
            throw Exception(context
                .getString(R.string.ErrorMsgAddU))

        }
    }

    suspend fun getByUsername(username: String): User?{
        var user: User?
        try {
            user = null
            val response = SOSAPIService.apiUser.getByUsername(username)
            if (response.responseCode != 200)
                return user

            Log.d("API_Call", "Success: ${response.data}")
            if (response.data.any()){
                user = getUserObject(response.data[0])
            }else{
                throw Exception(context
                    .getString(R.string.ErrorMsgGetByUser))
            }
        }catch (e: Exception){
            Log.e("API_Call", "Error fetching data: ${e.message}")
            throw Exception(context
                .getString(R.string.ErrorMsgGetByUser))
        }
        return user
    }

    suspend fun getByEmail(email: String): User?{
        var user: User?
        try {
            user = null
            val response = SOSAPIService.apiUser.getByEmail(email)
            if (response.responseCode != 200)
                return user

            Log.d("API_Call", "Success: ${response.data}")
            if (response.data.any()){
                user = getUserObject(response.data[0])
            }else{
                throw Exception(context
                    .getString(R.string.ErrorMsgGetByEmail))
            }
        }catch (e: Exception){
            Log.e("API_Call", "Error fetching data: ${e.message}")
            throw Exception(context
                .getString(R.string.ErrorMsgGetByEmail))
        }
        return user
    }

    suspend fun changePassword(user: User, password: String) {
        try {
            val request = PasswordRequest(newPassword = password)

            val response = SOSAPIService.apiUser
                .updatePassword(user.Username, request)

            if (response.responseCode != 200)
                throw Exception(response.message)

        } catch (e: Exception) {
            throw Exception(
                context.getString(R.string.ErrorMsgUpdPass)
            )
        }
    }

    suspend fun changePhone(user: User, phone: String) {
        try {
            val request = PhoneRequest(newPhone = phone)

            val response = SOSAPIService.apiUser
                .updatePhone(user.Username, request)

            if (response.responseCode != 200)
                throw Exception(response.message)

        } catch (e: Exception) {
            throw Exception(
                context.getString(R.string.ErrorMsgUpdPhone)
            )
        }
    }

    private fun getUserObject (item: DTOUser): User{
        val user = User()
        user.Username= item.Username
        user.Email= item.Email
        user.Password= item.Password
        user.PhoneNumber= item.PhoneNumber
        return user
    }

    private fun convertToDTOUserObject (user: User): DTOUser{
        return DTOUser(user.Username, user.Email, user.Password, user.PhoneNumber)
    }

}