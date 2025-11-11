package Controller

import Data.IDataManagerAlert
import Data.MemoryDataManager
import Entity.Alert
import android.content.Context
import com.example.proyectoprogramadoi.R

class AlertController {
    private var dataManager: IDataManagerAlert = MemoryDataManager
    private lateinit var context: Context

    constructor(context: Context){
        this.context=context
    }

    fun addA(alert: Alert){
        try {
            dataManager.addAlert(alert)
        }catch (e: Exception){
            throw Exception(context.getString(R.string.ErrorMsgAddA))
        }
    }

    fun getAlertByU(idUser: Int){
        try {
            dataManager.getAlertByUser(idUser)
        }catch (e: Exception){
            throw Exception(context.getString(R.string.ErrorMsgGetA))
        }
    }
}