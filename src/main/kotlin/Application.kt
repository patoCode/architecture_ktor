package f5


import f5.infraestructure.logging.LogbackAdapter
import io.ktor.server.application.*

fun main(args: Array<String>) {
    val logger = LogbackAdapter(Application::class.java)
    logger.info("::::::::::: Inicio del servicio :::::::::::")
    io.ktor.server.netty.EngineMain.main(args)

}

fun Application.module() {
    configureRouting()
    configureSerialization()
    configureKoin()
}
