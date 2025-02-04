package f5.application.ticket.request

import io.ktor.server.plugins.requestvalidation.*
import kotlinx.serialization.Serializable

@Serializable
data class TicketRequest(
    val id: String?,
    val userId: String,
    val categoryId: String,
    val description: String
)

fun validateTicketRequest(ticketRequest: TicketRequest): ValidationResult {
    return when {
        ticketRequest.userId.isBlank() -> {
            ValidationResult.Invalid("User ID is required")
        }
        ticketRequest.categoryId.equals("0") -> ValidationResult.Invalid("Category ID tiene que ser mayor a Cero")
        ticketRequest.categoryId.isBlank() -> ValidationResult.Invalid("Category ID is required")
        ticketRequest.description.isBlank() -> ValidationResult.Invalid("Description is required")
        else -> ValidationResult.Valid
    }
}

fun validateTicketFindByIdRequest(id: String): ValidationResult {
    return if (id.isNullOrBlank()) {
        ValidationResult.Invalid("ID is required")
    } else {
        ValidationResult.Valid
    }
}