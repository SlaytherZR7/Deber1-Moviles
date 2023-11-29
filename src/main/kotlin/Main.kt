import model.dao.implementaciones.DirectorDAO
import model.dao.implementaciones.FactoryDAOImpl
import model.dao.implementaciones.PeliculaDAO
import model.dao.interfaces.FactoryDAO
import model.entities.Director
import model.entities.Pelicula
import java.util.*

fun main(args: Array<String>) {

    FactoryDAO.getFactory().getDirectorDAO().save(Director(1, "Steven", "Spielberg", "Ecuador", Date(), emptyList()))
}