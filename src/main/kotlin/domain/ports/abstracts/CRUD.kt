package f5.domain.ports.abstracts


interface CRUD<P,R> {
    fun create(request: R): P
    fun getAll(): List<P>
    fun findById(id: String): P?
    fun update(id: String, request: R): P?
    fun delete(id: String): Boolean
}