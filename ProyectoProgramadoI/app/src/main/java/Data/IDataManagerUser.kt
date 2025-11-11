package Data

import Entity.User
import android.content.Context

interface IDataManagerUser {
    fun addUser(user: User)
    fun updatePassword(context: Context, username: String, newPassword: String)
    fun getByUsername(username: String): User?
    fun getByEmail(email: String):User?
    fun changePassword(user: User, password: String)
    fun changePhone(user: User, phone: String)
    
}