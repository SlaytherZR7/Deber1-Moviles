package model.entities

import java.util.Date

class Pelicula(
    val id: Int,
    var titulo: String,
    var genero: String,
    var fechaEstreno: Date,
    var soloEnCines: Boolean,
    var precio: Double
) {
    override fun toString(): String {
        return "Pelicula(id=$id, titulo='$titulo', genero='$genero', fechaEstreno=$fechaEstreno, soloEnCines=$soloEnCines, precio=$precio)"
    }
}