package f5.infraestructure.logging


import f5.domain.ports.LoggerPort
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class LogbackAdapter(private val clazz: Class<*>) : LoggerPort {
    private val logger: Logger = LoggerFactory.getLogger(clazz)

    override fun debug(message: String) {
        logger.debug(message)
    }

    override fun info(message: String) {
        logger.info(message)
    }

    override fun warn(message: String) {
        logger.warn(message)
    }

    override fun error(message: String, throwable: Throwable?) {
        logger.error(message, throwable)
    }
}