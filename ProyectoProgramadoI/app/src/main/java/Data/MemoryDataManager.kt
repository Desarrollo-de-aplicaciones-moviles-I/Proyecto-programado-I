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

    override fun updateContact(contacto: EmergencyContact){
        removeContact(contacto.Id)
        addContact(contacto)
    }

    override fun removeContact(id: Int){
        eContactList.removeIf { it.Id == id }
    }

    override fun getEContactsByUser(idUsuario: Int): List<EmergencyContact>{
        return eContactList.filter { it.IdUser == idUsuario }
    }

    //--------------------------------------------------
    // USERS
    override fun addUser(usuario: User){
        userList.add(usuario)
    }

    override fun updatePassword(userId: Int, newPassword: String) {
        val user = userList.find { it.Id == userId }
        if (user != null) {
            user.Contrasena = newPassword
            println("Contraseña actualizada para usuario ID $userId")
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

}