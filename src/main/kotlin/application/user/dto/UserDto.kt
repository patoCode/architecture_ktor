package f5.application.user.dto

import f5.domain.enums.Status
import f5.domain.enums.UserStatus

data class UserDto(
    val id: String,
    val fullname: String,
    val username: String,
    val email: String,
    val status: UserStatus,
    val createdAt: String
)
