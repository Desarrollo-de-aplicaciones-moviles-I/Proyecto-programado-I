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

    fun removeC(id: Int){
        try {
            dataManager.removeContact(id)
        }catch (e: Exception){
            throw Exception(context.getString(R.string.ErrorMsgRemoveC))
        }
    }

    fun getEContactsByU(id: Int){
        try {
            dataManager.getEContactsByUser(id)
        }catch (e: Exception){
            throw Exception(context.getString(R.string.ErrorMsgGetC))
        }
    }



}