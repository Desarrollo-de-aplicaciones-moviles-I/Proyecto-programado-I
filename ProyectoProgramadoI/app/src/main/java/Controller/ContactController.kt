package Controller

import Data.IDataManagerContact
import Data.MemoryDataManager
import Entity.EmergencyContact
import android.content.Context
import com.example.proyectoprogramadoi.R

class ContactController {
    private var dataManager: IDataManagerContact = MemoryDataManager
    private lateinit var context: Context

    constructor(context: Context){
        this.context=context
    }

    fun addC(contacto: EmergencyContact){
        try {
            dataManager.addContact(contacto)
        }catch (e: Exception){
            throw Exception(context.getString(R.string.ErrorMsgAddC))
        }
    }

    fun updateC(contacto: EmergencyContact){
        try {
            dataManager.updateContact(contacto)
        }catch (e: Exception){
            throw Exception(context.getString(R.string.ErrorMsgUpdC))
        }
    }

    fun removeC(name: String){
        try {
            dataManager.removeContact(name)
        }catch (e: Exception){
            throw Exception(context.getString(R.string.ErrorMsgRemoveC))
        }
    }

    fun getEContactsByU(nameUser: String){
        try {
            dataManager.getEContactsByUser(nameUser)
        }catch (e: Exception){
            throw Exception(context.getString(R.string.ErrorMsgGetC))
        }
    }

    fun getEContactsByN(nameContact: String): EmergencyContact?{
        try {
            return dataManager.getEContactsByName(nameContact)
        }catch (e: Exception){
            throw Exception(context.getString(R.string.ErrorMsgGetC))
        }
    }

    fun getEContactsByP(phoneContact: String): EmergencyContact?{
        try {
            return dataManager.getEContactsByPhone(phoneContact)
        }catch (e: Exception){
            throw Exception(context.getString(R.string.MsgDuplicatedNumberC))
        }
    }


}