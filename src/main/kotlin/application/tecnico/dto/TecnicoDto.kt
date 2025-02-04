package f5.application.tecnico.dto

import kotlinx.serialization.Serializable

@Serializable
data class TecnicoDto(
    val id: String,
    val nombre: String
)
