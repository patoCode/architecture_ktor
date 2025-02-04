package f5.application.rol

import f5.application.rol.request.RolRequest
import f5.domain.enums.Status
import f5.domain.ports.abstracts.CRUD
import f5.domain.entities.rol.Rol
import java.util.UUID


class RolService:  CRUD<Rol, RolRequest> {

    private val rols = mutableListOf<Rol>()

    override fun create(request: RolRequest): Rol {
        println("::::::::::: CREANDO :::::::::::")
        val new = Rol(
            id = UUID.randomUUID().toString(),
            nombre = request.nombre,
            padre = request.padre,
            status = Status.ACTIVE,
        )
        rols.add(new)
        return new
    }

    override fun getAll(): List<Rol> = rols

    override fun findById(id: String): Rol? {
        TODO("Not yet implemented")
    }

    override fun delete(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun update(id: String, request: RolRequest): Rol? {
        TODO("Not yet implemented")
    }

}