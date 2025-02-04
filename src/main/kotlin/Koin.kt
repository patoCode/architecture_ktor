package f5

import f5.application.tecnico.TecnicoService
import f5.application.user.UserService
import io.ktor.server.application.*
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

val appModule = module{
    single{ UserService() }
    single{ TecnicoService() }
}

fun Application.configureKoin() {
    install(Koin){
        slf4jLogger()
        modules(appModule)
    }
}

