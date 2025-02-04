package f5.domain.entities.user

import f5.domain.enums.Status
import kotlinx.serialization.Serializable

@Serializable
data class UserRol(
    val id: String,
    val usuario_id: String,
    val rol_id: String,
    val status: Status,
)

