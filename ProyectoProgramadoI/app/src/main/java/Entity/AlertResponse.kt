package Entity

data class AlertResponse(
    val data: DTOAlert?,
    val responseCode: Int,
    val message: String
)
