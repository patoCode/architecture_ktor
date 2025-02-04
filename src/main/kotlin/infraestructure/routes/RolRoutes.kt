package f5.infraestructure.web

import f5.application.rol.RolService
import f5.application.rol.request.RolRequest
import f5.application.rol.request.validateRolRequest
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.requestvalidation.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.rolRoutes(service: RolService) {
    routing{
        route("rol"){
            get{
                println("::::::::::: ROL - LISTANDO TODOS :::::::::::")
                call.respond(HttpStatusCode.OK, service.getAll())
            }
            post{
                println("::::::::::: ROL - CREATE :::::::::::")
                val req = call.receive<RolRequest>()
                val validationResult = validateRolRequest(req)
                if(validationResult is ValidationResult.Invalid){
                    call.respond(HttpStatusCode.BadRequest, validationResult.reasons)
                    return@post
                }
                val toPresist = service.create(req)
                call.respond(HttpStatusCode.OK, toPresist)
            }
        }
    }
}