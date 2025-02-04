package f5.domain.entities.ticket

import f5.domain.enums.StatusTicket
import kotlinx.serialization.Serializable

@Serializable
class Ticket (
    val id: String,
    val userId: String,
    val categoryId: String,
    val code: String,
    val description: String,
    val status: StatusTicket,
    val createdAt: String,
    val assignedTo: String? = null
)
