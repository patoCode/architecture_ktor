package f5.application.tecnico.request

import kotlinx.serialization.Serializable

@Serializable
data class TecnicoRequest(
    val id: String?,
    val usuario: String
)

