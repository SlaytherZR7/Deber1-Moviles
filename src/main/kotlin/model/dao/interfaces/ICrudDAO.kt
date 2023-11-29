package model.dao.interfaces

interface ICrudDAO<T, ID> {

    fun findAll(): List<T>
    fun findById(id: ID): T?
    fun save(t: T)
    fun update(t: T)
    fun deleteById(id: ID)
}