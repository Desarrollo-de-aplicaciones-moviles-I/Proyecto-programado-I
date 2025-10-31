package Data

import Entity.EmergencyContact

interface IDataManagerContact {
    fun addContact(contact: EmergencyContact)
    fun updateContact(contact: EmergencyContact)
    fun removeContact(id: Int)
    fun getEContactsByUser(idUser: Int): List<EmergencyContact>

}