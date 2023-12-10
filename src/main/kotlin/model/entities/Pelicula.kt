package model.entities

import java.util.Date
import java.util.UUID

class Pelicula(
    var titulo: String,
    var genero: String,
    var fechaEstreno: Date,
    var soloEnCines: Boolean,
    var precio: Double
) {
    val id = UUID.randomUUID()
    override fun toString(): String {
        return "Pelicula(titulo='$titulo', genero='$genero', fechaEstreno=$fechaEstreno, soloEnCines=$soloEnCines, precio=$precio)"
    }
}