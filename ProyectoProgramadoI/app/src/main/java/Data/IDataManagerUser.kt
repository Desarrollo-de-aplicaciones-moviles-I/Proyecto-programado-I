package Data

import Entity.User

interface IDataManagerUser {
    fun addUser(usuario: User)
    fun updatePassword(userId: Int, newPassword: String)
    fun updateEmail(userId: Int, newEmail: String)

}