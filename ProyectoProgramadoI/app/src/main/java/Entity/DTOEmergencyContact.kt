package Entity

import com.google.gson.annotations.SerializedName

data class DTOEmergencyContact(@SerializedName("Name") val Name: String="",
                               @SerializedName("PhoneNumber") val PhoneNumber: String="",
                               @SerializedName("NameUser") val NameUser: String=""
)
