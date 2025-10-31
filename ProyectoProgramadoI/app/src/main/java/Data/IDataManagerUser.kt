package Data

import Entity.User
import android.content.Context

interface IDataManagerUser {
    fun addUser(user: User)
    fun updatePassword(context: Context, userId: Int, newPassword: String)

}