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

    fun updatePass(context: Context, userId: Int, newPassword: String){
        try {
            dataManager.updatePassword(context, userId, newPassword)
        }catch (e: Exception){
            throw Exception(context.getString(R.string.ErrorMsgUpdPass))
        }
    }

}