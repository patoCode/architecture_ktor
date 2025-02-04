package f5.infraestructure.web

import f5.application.user.UserService
import f5.application.user.request.UserRequest
import f5.application.user.request.validateUserFindById
import f5.application.user.request.validateUserRequest
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.requestvalidation.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.userRoutes(service: UserService){
    routing {
        route("/user"){
            get{
                println("::::::::::: USER: LISTANDO :::::::::::")
                call.respond(HttpStatusCode.OK, service.getAll())
            }
            get("/{id}"){
                println("::::::::::: USER: FIND BY ID :::::::::::")
                val req = call.parameters["id"].toString().trim()

                val validationResult = validateUserFindById(req)

                if (validationResult is ValidationResult.Invalid) {
                    call.respond(HttpStatusCode.BadRequest, validationResult.reasons)
                    return@get
                }
                val user = service.findById(req)
                user?.let{
                    call.respond(HttpStatusCode.OK, it)
                } ?: call.respond(HttpStatusCode.NotFound, "Not Found User")
            }
            post{
                println("::::::::::: USER: CREANDO :::::::::::")
                var req = call.receive<UserRequest>()
                val validationResult = validateUserRequest(req)

                if (validationResult is ValidationResult.Invalid) {
                    call.respond(HttpStatusCode.BadRequest, validationResult.reasons)
                    return@post
                }

                val newItem = service.createUser(req)
                call.respond(HttpStatusCode.OK, newItem)
            }
        }
    }
}