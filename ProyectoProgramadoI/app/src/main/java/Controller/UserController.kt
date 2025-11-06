package Controller

import Data.IDataManagerUser
import Data.MemoryDataManager
import Entity.User
import android.content.Context
import com.example.proyectoprogramadoi.R

class UserController {
    private var dataManager: IDataManagerUser = MemoryDataManager
    private lateinit var context: Context

    constructor(context: Context){
        this.context=context
    }

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

}