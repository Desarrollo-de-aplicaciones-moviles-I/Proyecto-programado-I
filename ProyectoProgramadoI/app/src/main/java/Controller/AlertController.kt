package Controller

import Data.IDataManagerAlert
import Data.MemoryDataManager
import Entity.Alert
import Entity.EmergencyContact
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

    fun getAlertByU(idUser: String): List<Alert>{
        try {
            return dataManager.getAlertByUser(idUser)
        }catch (e: Exception){
            throw Exception(context.getString(R.string.ErrorMsgGetA))
        }
    }

    fun createID(): Int{
        try {
            return dataManager.createUniqueID()
        }catch (e: Exception){
            throw Exception(e)
        }
    }


}