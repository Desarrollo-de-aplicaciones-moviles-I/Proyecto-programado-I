package Data

import Entity.EmergencyContact


interface IDataManagerContact {
    fun addContact(contact: EmergencyContact)
    fun updateContact(contact: EmergencyContact)
    fun removeContact(name: String)
    fun getEContactsByUser(nameUser: String): List<EmergencyContact>
    fun getEContactsByName(nameContact: String): EmergencyContact?
    fun getEContactsByPhone(phoneContact: String): EmergencyContact?
}