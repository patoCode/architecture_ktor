package f5.application.ticket

import f5.application.ticket.request.TicketRequest
import f5.domain.enums.StatusTicket
import f5.domain.entities.ticket.Ticket
import f5.domain.entities.ticket.TicketCodeGenerator
import java.time.LocalDateTime
import java.util.*


class TicketService {

    private val tickets = mutableListOf<Ticket>()

    suspend fun createTicket(ticket: TicketRequest) {
        val code = TicketCodeGenerator.generateTicketCode()

        val newTicket = Ticket(
            id = UUID.randomUUID().toString(),
            userId = ticket.userId,
            categoryId = ticket.categoryId,
            description = ticket.description,
            code = code,
            status = StatusTicket.PENDING,
            createdAt = LocalDateTime.now().toString()
        )
        tickets.add(newTicket)
    }

    fun getAll() = tickets

    fun findById(ticket: String): Ticket? = tickets.find { it -> it.id.toString().trim().lowercase() == ticket.toString().trim().lowercase() }

    fun delete(ticket: String): Ticket?{
        val ticketRemoved = findById(ticket)
        tickets.removeIf{ it->it.id == ticket }
        return ticketRemoved
    }

}