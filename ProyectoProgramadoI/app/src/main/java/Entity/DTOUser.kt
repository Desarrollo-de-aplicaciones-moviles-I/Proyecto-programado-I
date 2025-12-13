package Entity

import com.google.gson.annotations.SerializedName

data class DTOUser(@SerializedName("Username") val Username: String="",
                     @SerializedName("Email") val Email: String="",
                     @SerializedName("Password") val Password: String="",
                     @SerializedName("PhoneNumber") val PhoneNumber: String=""
)