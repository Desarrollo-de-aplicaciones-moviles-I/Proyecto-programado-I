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

    fun addU(usuario: User){
        try {
            dataManager.addUser(usuario)
        }catch (e: Exception){
            throw Exception(context.getString(R.string.ErrorMsgAddU))
        }
    }

    fun updatePass(userId: Int, newPassword: String){
        try {
            dataManager.updatePassword(userId, newPassword)
        }catch (e: Exception){
            throw Exception(context.getString(R.string.ErrorMsgUpdPass))
        }
    }

    fun updateEmai(userId: Int, newEmail: String){
        try {
            dataManager.updateEmail(userId, newEmail)
        }catch (e: Exception){
            throw Exception(context.getString(R.string.ErrorMsgUpdEmai))
        }
    }

}