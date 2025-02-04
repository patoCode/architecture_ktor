package f5.domain.entities.ticket

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID

class TicketCodeGenerator {
    companion object {
        private var ticketCounter = 1000

        fun generateTicketCode(): String {
            val date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))
            val uniqueCode = ticketCounter++
            val uuid = UUID.randomUUID().toString().take(4)
            return "TKT-$date-$uniqueCode-$uuid"
        }
    }
}