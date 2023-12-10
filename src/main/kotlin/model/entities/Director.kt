package model.entities

import java.util.Date
import java.util.UUID


class Director(
    var nombre: String,
    var apellido: String,
    var nacionalidad: String,
    var fechaNacimiento: Date,
    var peliculas: List<Pelicula>
){
    val id = UUID.randomUUID()
    override fun toString(): String {
        return "Director(nombre='$nombre', apellido='$apellido', nacionalidad='$nacionalidad', fechaNacimiento=$fechaNacimiento)"
    }
}