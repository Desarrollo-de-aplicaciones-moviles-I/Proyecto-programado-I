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
        removeContact(contact.Name)
        addContact(contact)
    }

    override fun removeContact(name: String){
        eContactList.removeIf { it.Name == name }
    }

    override fun getEContactsByUser(nameUser: String): List<EmergencyContact>{
        return eContactList.filter { it.NameUser == nameUser }
    }

    override fun getEContactsByName(nameContact: String): EmergencyContact?{
        val result = eContactList.filter { it.Name.trim() == nameContact.trim() }
        return if(result.any()) result[0] else null
    }

    override fun getEContactsByPhone(phoneContact: String): EmergencyContact? {
        val result = eContactList.filter { it.PhoneNumber.trim() == phoneContact.trim() }
        return if(result.any()) result[0] else null

    }

    //--------------------------------------------------
    // USERS
    override fun addUser(user: User){
        userList.add(user)
    }

    override fun updatePassword(context: Context, username: String, newPassword: String) {
        val username = userList.find { it.Username == username }
        if (username != null) {
            username.Password = newPassword
            println(context.getString(R.string.MsgPasswordUpdated))
        } else {
            println(context.getString(R.string.MsgUserNotFound))
        }

    override fun getByUsername(username: String): User?{
        val result = userList.filter { it.Username.trim() == username.trim() }
        return if(result.any()) result[0] else null
    }
}