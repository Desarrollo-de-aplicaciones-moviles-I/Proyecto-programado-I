package Data

import Entity.User

interface IDataManagerUser {
<<<<<<< Updated upstream
    fun addUser(usuario: User)
    fun updatePassword(userId: Int, newPassword: String)
    fun updateEmail(userId: Int, newEmail: String)

=======
    fun addUser(user: User)
    fun updatePassword(context: Context, username: String, newPassword: String)
    fun getByUsername(username: String): User?
>>>>>>> Stashed changes
}