package Entity

data class EContactGetResponse(
    val data: List<DTOEmergencyContact>,
    val responseCode: Int,
    val message: String
)
