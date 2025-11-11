package Data

import Entity.Alert
import Entity.EmergencyContact
import Entity.User
import android.content.Context
import com.example.proyectoprogramadoi.R

object MemoryDataManager: IDataManagerAlert, IDataManagerContact, IDataManagerUser{
    ////// Variables and lists
    private var alertList = mutableListOf<Alert>()
    private var eContactList= mutableListOf<EmergencyContact>()
    private var userList = mutableListOf<User>()


    //--------------------------------------------------
    //ALERTS
    override fun addAlert(alert: Alert){
        alertList.add(alert)
    }

    override fun getAlertByUser(idUser: Int): List<Alert>{
        return alertList.filter { it.IdUser == idUser }
    }

    //--------------------------------------------------
    // CONTACTS
    override fun addContact(contact: EmergencyContact){
        eContactList.add(contact)
    }

    override fun updateContact(contact: EmergencyContact){
        removeContact(contact.Id)
        addContact(contact)
    }

    override fun removeContact(id: Int){
        eContactList.removeIf { it.Id == id }
    }

    override fun getEContactsByUser(idUser: Int): List<EmergencyContact>{
        return eContactList.filter { it.IdUser == idUser }
    }

    //--------------------------------------------------
    // USERS
    override fun addUser(user: User){
        userList.add(user)
    }

    override fun updatePassword(context: Context, userId: Int, newPassword: String) {
        val user = userList.find { it.Id == userId }
        if (user != null) {
            user.Contrasena = newPassword
            println(context.getString(R.string.MsgPasswordUpdated))
        } else {
            println(context.getString(R.string.MsgUserNotFound))
        }
    }

}