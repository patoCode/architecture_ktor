package f5.domain.entities.rol

import f5.domain.enums.Status
import kotlinx.serialization.Serializable

@Serializable
data class Rol (
    val id: String,
    val nombre: String,
    val status: Status,
    val padre: String? = null,
)