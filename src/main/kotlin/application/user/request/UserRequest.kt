package f5.application.user.request

import io.ktor.server.plugins.requestvalidation.*
import kotlinx.serialization.Serializable

@Serializable
data class UserRequest (
    val id: String?,
    val fullname: String,
    val username: String,
    val password: String,
    val email: String,
)

fun validateUserRequest(request: UserRequest): ValidationResult {
    val errors = mutableListOf<String>()

    if (request.fullname.isBlank()) errors.add("El fullname no puede estar vacío")
    if (request.username.isBlank()) errors.add("El username no puede estar vacío")
    if (!request.email.contains("@")) errors.add("El correo electrónico no es válido")
    if (request.password.isBlank()) errors.add("El password no puede estar vacío")
    return if (errors.isEmpty()) ValidationResult.Valid else ValidationResult.Invalid(errors)
}

fun validateUserFindById(id: String): ValidationResult{
    val errors = mutableListOf<String>()
    if (id.isBlank()) errors.add("El id no existe no puede estar vacío")
    return if (errors.isEmpty()) ValidationResult.Valid else ValidationResult.Invalid(errors)
}