package f5.application.user.request

import io.ktor.server.plugins.requestvalidation.*
import kotlinx.serialization.Serializable

@Serializable
data class UserRolRequest(
    val usuario: String,
    val rol: String,
)

fun validateUserRolRequest(request: UserRolRequest): ValidationResult{
    val errors = mutableListOf<String>()
    if(request.usuario.isBlank()) errors.add("El usuario no puede estar vacío")
    if(request.rol.isBlank()) errors.add("El rol no puede estar vacío")
    return if (errors.isEmpty()) ValidationResult.Valid else ValidationResult.Invalid(errors)
}
