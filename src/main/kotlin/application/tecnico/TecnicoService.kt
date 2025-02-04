package f5.application.tecnico

import f5.application.common.ServicesResponse
import f5.application.tecnico.dto.TecnicoDto
import f5.application.tecnico.request.TecnicoRequest
import f5.application.user.UserService
import f5.domain.entities.tecnico.Tecnico
import f5.domain.entities.user.User
import f5.domain.enums.Status
import f5.domain.ports.abstracts.CRUD
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

import java.util.*

class TecnicoService: CRUD<TecnicoDto, TecnicoRequest>, KoinComponent {
    private val usuarioService by inject<UserService>()

    private val tecnicos = mutableListOf<TecnicoDto>()
    private val tecnicosDB = mutableListOf<Tecnico>()



    fun createTecnico(request: TecnicoRequest): ServicesResponse<TecnicoDto> {
        val usuario: User? = usuarioService.findById(request.usuario)
        return usuario?.let{
            val toPersist = Tecnico(
                id = UUID.randomUUID().toString(),
                usuario = request.usuario,
                status = Status.ACTIVE
            )
            tecnicosDB.add(toPersist)
            ServicesResponse.Success(TecnicoDto(
                id = toPersist.id,
                nombre = toPersist.usuario
            ))
        } ?: ServicesResponse.Error("Error no se ha encontrado el usuario ")
    }

    override fun create(request: TecnicoRequest): TecnicoDto {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<TecnicoDto> = tecnicos

    override fun findById(id: String): TecnicoDto? {
        TODO("Not yet implemented")
    }

    override fun delete(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun update(id: String, request: TecnicoRequest): TecnicoDto? {
        TODO("Not yet implemented")
    }
}