package model.dao.implementaciones

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import model.dao.interfaces.IDirectorDAO
import model.entities.Director
import java.io.File
import java.util.*

class DirectorDAO : IDirectorDAO {

    private val gson = Gson()
    private val FILENAME = "src/main/resources/directores.json"

    private fun verificarArchivo() {
        val file = File(FILENAME)
        if (!file.exists()) {
            file.createNewFile()
        }
    }
    override fun getAll(): List<Director> {
        verificarArchivo()
        val directoresJson = File(FILENAME).readText()
        val tipoListaDirectores = object : TypeToken<List<Director>>() {}.type
        return gson.fromJson(directoresJson, tipoListaDirectores) ?: emptyList()
    }

    override fun getById(id: UUID): Director? {
        return getAll().find { it.id == id }
    }

    override fun save(director: Director) {
        verificarArchivo()
        val directores = getAll().toMutableList()
        directores.add(director)
        saveAll(directores)
    }

    override fun update(directorAntiguo: Director, directorNuevo: Director) {
        val directores = getAll().toMutableList()
        val index = directores.indexOfFirst { it.id == directorAntiguo.id }
        directores[index] = directorNuevo
        saveAll(directores)
    }

    override fun deleteById(id: UUID) {
        val directores = getAll().toMutableList()
        directores.remove(directores.find { it.id == id })
        saveAll(directores)
    }

    override fun saveAll(directores: List<Director>) {
        val directoresJson = gson.toJson(directores)
        File(FILENAME).writeText(directoresJson)
    }

}