package f5.application.user

import f5.application.user.request.UserRequest
import f5.application.user.request.UserRolRequest
import f5.domain.enums.Status
import f5.domain.entities.user.User
import f5.domain.entities.user.UserRol
import f5.domain.enums.UserStatus
import java.time.LocalDateTime
import java.util.UUID

class UserService{

    private val users = mutableListOf<User>()
    private val user_rol = mutableListOf<UserRol>()

    fun getAll() = users

    fun findById(id: String): User? = users.find{ it -> it.id == id }

    fun createUser(request: UserRequest): User {
        val toPersist = User(
            id = UUID.randomUUID().toString(),
            fullname = request.fullname,
            username = request.username,
            password = request.password,
            email = request.email,
            status = UserStatus.ACTIVE,
            createdAt = LocalDateTime.now().toString()
        )
        users.add(toPersist)
        return toPersist
    }

    fun getRolsByUser(request: UserRequest): List<UserRol> = user_rol.filter{ it-> it.usuario_id == request.id }.toMutableList()

    fun assignRol(request: UserRolRequest): UserRol {
        val toPersist = UserRol(
            id = UUID.randomUUID().toString(),
            rol_id = request.rol,
            usuario_id = request.usuario,
            status = Status.ACTIVE
        )
        user_rol.add(toPersist)
        return toPersist
    }

}

