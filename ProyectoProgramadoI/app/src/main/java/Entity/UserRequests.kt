package Entity

data class PasswordRequest(
    val newPassword: String
)

data class PhoneRequest(
    val newPhone: String
)

data class LoginRequest(
    val username: String,
    val password: String
)

data class LogoutRequest(
    val username: String
)