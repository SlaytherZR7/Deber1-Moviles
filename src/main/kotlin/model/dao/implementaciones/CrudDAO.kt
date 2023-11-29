package model.dao.implementaciones

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import model.dao.interfaces.ICrudDAO
import java.io.File


open class CrudDAO<T, ID>(private val persistentClass: Class<T>) : ICrudDAO<T, ID> {

    val gson = Gson()
    private val filename = "src/main/resources/${persistentClass.simpleName}.json"

    override fun findAll(): List<T> {
        val fileContent = File(filename).readText()
        val listType = object : TypeToken<List<T>>() {}.type
        return gson.fromJson(fileContent, listType) ?: emptyList()
    }

    override fun findById(id: ID): T? {
        val allItems = findAll()
        return allItems.find { getItemId(it) == id }
    }

    override fun save(t: T) {
        val allItems = findAll().toMutableList()
        allItems.add(t)
        saveAll(allItems)
    }

    override fun update(t: T) {
        val allItems = findAll().toMutableList()
        val existingItem = allItems.find { getItemId(it) == getItemId(t) }
        existingItem?.let {
            val index = allItems.indexOf(it)
            allItems[index] = t
            saveAll(allItems)
        }
    }

    override fun deleteById(id: ID) {
        val allItems = findAll().toMutableList()
        val itemToRemove = allItems.find { getItemId(it) == id }
        itemToRemove?.let {
            allItems.remove(it)
            saveAll(allItems)
        }
    }

    private fun getItemId(t: T): ID {
        val idField = persistentClass.declaredFields.find { it.name == "id" }
        idField?.let {
            it.isAccessible = true
            return it.get(t) as ID
        }
        throw Exception("No se pudo obtener el id del item")
    }

    private fun saveAll(list: List<T>) {
        val json = gson.toJson(list)
        File(filename).writeText(json)
    }
}