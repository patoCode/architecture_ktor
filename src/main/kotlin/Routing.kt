package f5

import f5.application.rol.RolService
import f5.application.ticket.TicketService
import f5.application.user.UserService
import f5.infraestructure.web.rolRoutes
import f5.infraestructure.web.ticketRoutes
import f5.infraestructure.web.userRoutes
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        ticketRoutes(TicketService())
        userRoutes(UserService())
        rolRoutes(RolService())
    }
}
