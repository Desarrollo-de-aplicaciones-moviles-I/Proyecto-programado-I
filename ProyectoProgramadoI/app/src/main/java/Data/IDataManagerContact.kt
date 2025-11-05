package Data

import Entity.EmergencyContact


interface IDataManagerContact {
<<<<<<< Updated upstream
    fun addContact(contacto: EmergencyContact)
    fun updateContact(contacto: EmergencyContact)
    fun removeContact(id: Int)
    fun getEContactsByUser(idUsuario: Int): List<EmergencyContact>

=======
    fun addContact(contact: EmergencyContact)
    fun updateContact(contact: EmergencyContact)
    fun removeContact(name: String)
    fun getEContactsByUser(nameUser: String): List<EmergencyContact>
    fun getEContactsByName(nameContact: String): EmergencyContact?
    fun getEContactsByPhone(phoneContact: String): EmergencyContact?
>>>>>>> Stashed changes
}