package f5.domain.enums

enum class Status { ACTIVE, INACTIVE }

enum class Priority{
    LOW, MEDIUM, HIGH, CRITICAL
}

enum class StatusBitacora{
    ACTUAL, PARTIAL, FINISH
}

enum class StatusTicket{
    PENDING,
    ON_PROGRESS,
    PAUSE,
    WAITING_FOR_CLIENT,
    WAITING_FOR_PARTS,
    SCHEDULED,
    ESCALATED,
    DONE,
    CLOSED  ,
    CANCELLED  ,
    REJECTED
}

enum class UserStatus{
    ACTIVE, INACTIVE
}
