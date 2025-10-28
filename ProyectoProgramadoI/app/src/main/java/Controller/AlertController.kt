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

    fun addA(alerta: Alert){
        try {
            dataManager.addAlert(alerta)
        }catch (e: Exception){
            throw Exception(context.getString(R.string.ErrorMsgAddA))
        }
    }

    fun getAlertByU(idUsuario: Int){
        try {
            dataManager.getAlertByUser(idUsuario)
        }catch (e: Exception){
            throw Exception(context.getString(R.string.ErrorMsgGetA))
        }
    }
}