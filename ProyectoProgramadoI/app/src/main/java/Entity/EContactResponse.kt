package Entity

data class EContactResponse(
    val data: DTOEmergencyContact?,
    val responseCode: Int,
    val message: String
)
