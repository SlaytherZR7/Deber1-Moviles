package model.entities

import java.util.Date


class Director(
    val id: Int,
    var nombre: String,
    var apellido: String,
    var nacionalidad: String,
    var fechaNacimiento: Date,
    var peliculas: List<Pelicula>
) {
    override fun toString(): String {
        return "Director(id=$id, nombre='$nombre', apellido='$apellido', nacionalidad='$nacionalidad', fechaNacimiento='$fechaNacimiento', peliculas=$peliculas)"
    }
}