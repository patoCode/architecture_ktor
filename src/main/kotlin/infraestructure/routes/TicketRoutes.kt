package f5.infraestructure.web

import f5.application.ticket.TicketService
import f5.application.ticket.request.TicketRequest
import f5.application.ticket.request.validateTicketFindByIdRequest
import f5.application.ticket.request.validateTicketRequest
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.requestvalidation.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.ticketRoutes(service: TicketService){
    routing {
        route("ticket"){
            get{
                println("::::::::::: LISTANDO TODOS :::::::::::")
                call.respond(HttpStatusCode.OK, service.getAll())
            }
            get("/{id}"){
                println("::::::::::: FIND BY ID :::::::::::")
                val req = call.parameters["id"].toString().trim()
                val validationResult = validateTicketFindByIdRequest(req)
                if (validationResult is ValidationResult.Invalid) {
                    call.respond(HttpStatusCode.BadRequest, validationResult.reasons)
                    return@get
                }
                val item = service.findById(req)
                item?.let{
                    call.respond(HttpStatusCode.OK, it)
                } ?: call.respond(HttpStatusCode.NotFound, "Not Found Ticket")
            }
            post{
                println("::::::::::: CREANDO :::::::::::")
                val req = call.receive<TicketRequest>()
                val validationResult = validateTicketRequest(req)

                if (validationResult is ValidationResult.Invalid) {
                    call.respond(HttpStatusCode.BadRequest, validationResult.reasons)
                    return@post
                }

                val toPresist = service.createTicket(req)
                call.respond(HttpStatusCode.OK, toPresist)
            }
            delete("/{id}"){
                println("::::::::::: DELETE :::::::::::")
                val req = call.parameters["id"].toString().trim()
                val validationResult = validateTicketFindByIdRequest(req)
                if (validationResult is ValidationResult.Invalid) {
                    call.respond(HttpStatusCode.BadRequest, validationResult.reasons)
                    return@delete
                }
                val item = service.delete(req)
                item?.let{
                    call.respond(HttpStatusCode.OK, it)
                } ?: call.respond(HttpStatusCode.NotFound, "Not Found Ticket")
            }
        }

    }
}