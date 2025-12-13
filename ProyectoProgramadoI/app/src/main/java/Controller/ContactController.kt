package Controller

import Data.IDataManagerContact
import Data.MemoryDataManager
import Entity.DTOEmergencyContact
import Entity.DTOUser
import Entity.EmergencyContact
import Entity.PasswordRequest
import Entity.PhoneRequest
import Entity.User
import Util.SOSAPIService
import android.content.Context
import android.util.Log
import com.example.proyectoprogramadoi.R

class ContactController {
    private var dataManager: IDataManagerContact = MemoryDataManager
    private lateinit var context: Context

    constructor(context: Context) {
        this.context = context
    }

    /*
    fun addC(contact: EmergencyContact){
        try {
            dataManager.addContact(contact)
        }catch (e: Exception){
            throw Exception(context.getString(R.string.ErrorMsgAddC))
        }
    }

    fun updateC(contact: EmergencyContact) {
        try {
            dataManager.updateContact(contact)
        } catch (e: Exception) {
            throw Exception(context.getString(R.string.ErrorMsgUpdC))
        }
    }

    fun removeC(name: String) {
        try {
            dataManager.removeContact(name)
        } catch (e: Exception) {
            throw Exception(context.getString(R.string.ErrorMsgRemoveC))
        }
    }

    fun getEContactsByU(nameUser: String): List<EmergencyContact> {
        try {
            return dataManager.getEContactsByUser(nameUser)
        } catch (e: Exception) {
            throw Exception(context.getString(R.string.ErrorMsgGetC))
        }
    }

    fun getEContactsByN(nameContact: String): EmergencyContact? {
        try {
            return dataManager.getEContactsByName(nameContact)
        } catch (e: Exception) {
            throw Exception(context.getString(R.string.ErrorMsgGetC))
        }
    }

    fun getEContactsByP(phoneContact: String): EmergencyContact? {
        try {
            return dataManager.getEContactsByPhone(phoneContact)
        } catch (e: Exception) {
            throw Exception(context.getString(R.string.MsgDuplicatedNumberC))
        }
    }
*/
    //----------------------------------------------------------------------------------
    //Logica de implementacion de la API
    //----------------------------------------------------------------------------------
    suspend fun addC(contact: EmergencyContact) {
        try {
            val response = SOSAPIService.apiEContact.postContact(convertToDTOContactObject(contact))
            if (response.responseCode != 200)
                throw Exception(response.message)

        } catch (e: Exception) {
            Log.e("API_Call", "Error fetching data: ${e.message}")
            throw Exception(
                context
                    .getString(R.string.ErrorMsgAddC)
            )

        }
    }

    suspend fun getEContactsByU(nameUser: String): List<DTOEmergencyContact> {
        var contacts: List<DTOEmergencyContact>? = emptyList()
        try {
            val response = SOSAPIService.apiEContact.getContactByUser(nameUser)
            if (response.responseCode != 200)
                throw Exception(context.getString(R.string.ErrorMsgGetC))

            Log.d("API_Call", "Success: ${response.data}")
            if (response.data.any()) {
                contacts = response.data
            } else {
                throw Exception(context.getString(R.string.ErrorMsgGetC))
            }

        } catch (e: Exception) {
            Log.e("API_Call", "Error fetching data: ${e.message}")
            throw Exception(context.getString(R.string.ErrorMsgGetC))
        }
        return contacts
    }

    suspend fun getEContactsByN(nameContact: String): EmergencyContact?{
        var contact: EmergencyContact?
        try {
            contact = null
            val response = SOSAPIService.apiEContact.getContactByCName(nameContact)
            if (response.responseCode != 200)
                return contact

            Log.d("API_Call", "Success: ${response.data}")
            if (response.data.any()){
                contact = getContactObject(response.data[0])
            }else{
                throw Exception(context
                    .getString(R.string.ErrorMsgGetByEmail))
            }
        }catch (e: Exception){
            Log.e("API_Call", "Error fetching data: ${e.message}")
            throw Exception(context
                .getString(R.string.ErrorMsgGetByEmail))
        }
        return contact
    }

    suspend fun getEContactsByP(phoneContact: String): EmergencyContact?{
        var contact: EmergencyContact?
        try {
            contact = null
            val response = SOSAPIService.apiEContact.getContactByPhone(phoneContact)
            if (response.responseCode != 200)
                return contact

            Log.d("API_Call", "Success: ${response.data}")
            if (response.data.any()){
                contact = getContactObject(response.data[0])
            }else{
                throw Exception(context
                    .getString(R.string.ErrorMsgGetByEmail))
            }
        }catch (e: Exception){
            Log.e("API_Call", "Error fetching data: ${e.message}")
            throw Exception(context
                .getString(R.string.ErrorMsgGetByEmail))
        }
        return contact
    }

    suspend fun removeC(name: String){
        try{
            val response = SOSAPIService.apiEContact.deleteContact(name)
            if (response.responseCode != 200)
                throw Exception(response.message)
        }catch (e: Exception){
            Log.e("API_Call", "Error fetching data: ${e.message}")
            throw Exception(context
                .getString(R.string.ErrorMsgRemoveC))
        }
    }

    suspend fun updateC(contact: EmergencyContact){
        try {
            val response = SOSAPIService.apiEContact.updateContact(convertToDTOContactObject(contact))
            if (response.responseCode != 200)
                throw Exception(response.message)
        }catch (e: Exception){
            throw Exception(context
                .getString(R.string.ErrorMsgUpdC))

        }
    }

    private fun getContactObject (item: DTOEmergencyContact): EmergencyContact{
        val contact = EmergencyContact()
        contact.Name = item.Name
        contact.PhoneNumber= item.PhoneNumber
        contact.NameUser= item.NameUser
        return contact
    }

    private fun convertToDTOContactObject (contact: EmergencyContact): DTOEmergencyContact{
        return DTOEmergencyContact(contact.Name, contact.PhoneNumber, contact.NameUser)
    }

}