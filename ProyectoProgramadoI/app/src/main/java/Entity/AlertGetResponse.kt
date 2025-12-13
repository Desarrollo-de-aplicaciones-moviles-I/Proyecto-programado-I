package Entity

data class AlertGetResponse(
    val data: List<DTOAlert>,
    val responseCode: Int,
    val message: String
)
