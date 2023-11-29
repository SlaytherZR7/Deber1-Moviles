package model.dao.implementaciones

import model.dao.interfaces.IPeliculaDAO
import model.entities.Pelicula

class PeliculaDAO: CrudDAO<Pelicula, Int>(Pelicula::class.java), IPeliculaDAO{
}