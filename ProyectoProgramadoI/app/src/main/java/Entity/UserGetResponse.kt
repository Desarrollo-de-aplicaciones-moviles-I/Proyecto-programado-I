package Entity

data class UserGetResponse(
    val data: List<DTOUser>,
    val responseCode: Int,
    val message: String
)
