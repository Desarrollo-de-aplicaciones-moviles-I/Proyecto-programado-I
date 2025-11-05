package Data

import Entity.Alert
import Entity.EmergencyContact
import Entity.User

object MemoryDataManager: IDataManagerAlert, IDataManagerContact, IDataManagerUser{
    ////// Varibales y Listas
    private var alertList = mutableListOf<Alert>()
    private var eContactList= mutableListOf<EmergencyContact>()
    private var userList = mutableListOf<User>()

    //--------------------------------------------------
    //ALERTS
    override fun addAlert(alerta: Alert){
        alertList.add(alerta)
    }

    override fun getAlertByUser(idUsuario: Int): List<Alert>{
        return alertList.filter { it.IdUser == idUsuario }
    }

    //--------------------------------------------------
    // CONTACTS
    override fun addContact(contacto: EmergencyContact){
        eContactList.add(contacto)
    }

<<<<<<< Updated upstream
    override fun updateContact(contacto: EmergencyContact){
        removeContact(contacto.Id)
        addContact(contacto)
=======
    override fun updateContact(contact: EmergencyContact){
        removeContact(contact.Name)
        addContact(contact)
>>>>>>> Stashed changes
    }

    override fun removeContact(name: String){
        eContactList.removeIf { it.Name == name }
    }

<<<<<<< Updated upstream
    override fun getEContactsByUser(idUsuario: Int): List<EmergencyContact>{
        return eContactList.filter { it.IdUser == idUsuario }
=======
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
>>>>>>> Stashed changes
    }

    //--------------------------------------------------
    // USERS
    override fun addUser(usuario: User){
        userList.add(usuario)
    }

<<<<<<< Updated upstream
    override fun updatePassword(userId: Int, newPassword: String) {
        val user = userList.find { it.Id == userId }
        if (user != null) {
            user.Contrasena = newPassword
            println("Contraseña actualizada para usuario ID $userId")
=======
    override fun updatePassword(context: Context, username: String, newPassword: String) {
        val username = userList.find { it.Username == username }
        if (username != null) {
            username.Password = newPassword
            println(context.getString(R.string.MsgPasswordUpdated))
>>>>>>> Stashed changes
        } else {
            println("Usuario con ID $userId no encontrado")
        }
    }

    override fun updateEmail(userId: Int, newEmail: String) {
        val user = userList.find { it.Id == userId }
        if (user != null) {
            user.Correo = newEmail
            println("Email actualizado para usuario ID $userId")
        } else {
            println("Usuario con ID $userId no encontrado")
        }
    }

    override fun getByUsername(username: String): User?{
        val result = userList.filter { it.Username.trim() == username.trim() }
        return if(result.any()) result[0] else null
    }
}