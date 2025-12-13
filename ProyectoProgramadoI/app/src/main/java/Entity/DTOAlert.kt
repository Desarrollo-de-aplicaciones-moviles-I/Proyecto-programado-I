package Entity

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

data class DTOAlert(
    @SerializedName("IdAlert") val IdAlert: Int,
    @SerializedName("DateAlert") val DateAlert: String,
    @SerializedName("Message") val Message: String? = null,
    @SerializedName("Latitude") val Latitude: Int = 1,
    @SerializedName("Longitude") val Longitude: Int = 1,
    @SerializedName("IdUser") val IdUser: String = ""
)