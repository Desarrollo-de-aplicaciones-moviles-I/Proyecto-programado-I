package Controller

import Data.IDataManagerAlert
import Data.MemoryDataManager
import Entity.Alert
import Entity.DTOAlert
import Entity.DTOEmergencyContact
import Entity.EmergencyContact
import Util.SOSAPIService
import Util.Util
import android.content.Context
import android.util.Log
import com.example.proyectoprogramadoi.R
import java.time.LocalDate
import java.time.LocalDateTime

class AlertController {
    private var dataManager: IDataManagerAlert = MemoryDataManager
    private lateinit var context: Context

    constructor(context: Context){
        this.context=context
    }

    /*
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
*/
    fun createID(): Int{
        try {
            return dataManager.createUniqueID()
        }catch (e: Exception){
            throw Exception(e)
        }
    }

//----------------------------------------------------------------------------------
//Logica de implementacion de la API
//----------------------------------------------------------------------------------
    suspend fun addA(alert: Alert) {
        try {
            val response = SOSAPIService.apiAlert.postAlert(convertToDTOAlertObject(alert))
            if (response.responseCode != 200)
                throw Exception(response.message)

        } catch (e: Exception) {
            Log.e("API_Call", "Error fetching data: ${e.message}")
            throw Exception(
                context
                    .getString(R.string.ErrorMsgAddA)
            )

        }
    }

    suspend fun getAlertByU(idUser: String): List<DTOAlert>{
        var alerts: List<DTOAlert>? = emptyList()
        try {
            val response = SOSAPIService.apiAlert.getAlertsByUser(idUser)
            if (response.responseCode != 200)
                throw Exception(context.getString(R.string.ErrorMsgGetA))

            Log.d("API_Call", "Success: ${response.data}")
            if (response.data.any()) {
                alerts = response.data
            } else {
                throw Exception(context.getString(R.string.ErrorMsgGetA))
            }

        } catch (e: Exception) {
            Log.e("API_Call", "Error fetching data: ${e.message}")
            throw Exception(context.getString(R.string.ErrorMsgGetC))
        }
        return alerts
    }


    private fun getAlertObject(item: DTOAlert): Alert {
        val alert = Alert()
        alert.IdAlert = item.IdAlert
        val DateToString = item.DateAlert.toString()
        alert.DateAlert = parseLocalDateTime(DateToString)
        alert.Message = item.Message
        alert.Latitude = item.Latitude
        alert.Longitude = item.Longitude
        alert.IdUser = item.IdUser
        return alert
    }

    private fun convertToDTOAlertObject (alert: Alert): DTOAlert{
        val dateString = alert.DateAlert?.toString() ?: ""
        return DTOAlert(
            alert.IdAlert,
            dateString,
            alert.Message,
            alert.Latitude,
            alert.Longitude,
            alert.IdUser
        )
    }

    private fun parseLocalDateTime(value: String): LocalDateTime? {
        return try {
            LocalDateTime.parse(value.trim())
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

}