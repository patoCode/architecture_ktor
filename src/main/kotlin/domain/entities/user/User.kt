package f5.domain.entities.user

import f5.domain.enums.UserStatus
import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: String,
    val fullname: String,
    val username: String,
    val password: String,
    val email: String,
    val status: UserStatus,
    val createdAt: String
)


