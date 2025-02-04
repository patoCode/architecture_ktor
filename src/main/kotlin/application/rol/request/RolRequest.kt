package f5.application.rol.request

import io.ktor.server.plugins.requestvalidation.*
import kotlinx.serialization.Serializable

@Serializable
data class RolRequest (
    val id: String?,
    val nombre: String,
    val padre: String
)

fun validateRolRequest(rol: RolRequest): ValidationResult {
    return when {
        rol.nombre.isBlank() -> {
            ValidationResult.Invalid("rol name required")
        }
        else -> ValidationResult.Valid
    }
}