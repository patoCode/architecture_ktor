package f5.domain.entities.tecnico

import f5.domain.enums.Status
import kotlinx.serialization.Serializable

@Serializable
data class Tecnico(
    val id: String,
    val usuario: String,
    val status: Status
)
