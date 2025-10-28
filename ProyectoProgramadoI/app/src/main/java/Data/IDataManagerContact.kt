package Data

import Entity.EmergencyContact

interface IDataManagerContact {
    fun addContact(contacto: EmergencyContact)
    fun updateContact(contacto: EmergencyContact)
    fun removeContact(id: Int)
    fun getEContactsByUser(idUsuario: Int): List<EmergencyContact>

}