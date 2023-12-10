import model.dao.implementaciones.DirectorDAO
import model.entities.Director
import model.entities.Pelicula
import java.util.*

fun main(args: Array<String>) {

    llenarLista()
    val directorDAO = DirectorDAO()
    var opcion = 0

    while (opcion != 5) {
        var opcion = showMenu()
        when (opcion) {
            1 -> insertarDirector()
            2 -> getDirectores()
            3 -> {
                getDirectores()
                print("Ingrese el numero del director a actualizar:  ")
                val numeroDirector = readLine()?.toInt()
                val director = directorDAO.getAll()[numeroDirector!! - 1]
                print("Informacion actual del director:  ${director.toString()}")
                actualizarDirector(director)
            }
            4 -> {
                getDirectores()
                print("Ingrese el numero del director a eliminar:  ")
                val numeroDirector = readLine()?.toInt()
                val director = directorDAO.getAll()[numeroDirector!! - 1]
                directorDAO.deleteById(director.id)
            }
            5 -> println("Gracias por usar el programa")
            else -> println("Opcion no valida")
        }
    }
}

private fun showMenu(): Int {
    println("¿Que accion desea realizar?")
    println("-------------------------------")
    println("1 - Insertar nueva pelicula")
    println("2 - Ver lista de peliculas")
    println("3 - Actualizar pelicula")
    println("4 - Eliminar pelicula")
    println("5 - Salir")
    print("Ingrese el numero de la opcion:  ")
    return readln().toInt()
}

private fun getDirectores() {
    for (director in DirectorDAO().getAll().withIndex()) {
        println("${director.index + 1} - ${director.value.nombre} ${director.value.apellido}")
    }
}

private fun insertarDirector() {
    print("Ingrese el nombre del director:  ")
    val nombre = readLine()
    print("Ingrese el apellido del director:  ")
    val apellido = readLine()
    print("Ingrese la nacionalidad del director:  ")
    val nacionalidad = readLine()
    print("Ingrese la fecha de nacimiento del director:  ")
    val fechaNacimiento = readLine()
    DirectorDAO().save(Director(nombre!!, apellido!!, nacionalidad!!, Date(), emptyList()))
}

private fun actualizarDirector(director: Director) {
    print("Ingrese el nombre del director:  ")
    val nombre = readLine()
    print("Ingrese el apellido del director:  ")
    val apellido = readLine()
    print("Ingrese la nacionalidad del director:  ")
    val nacionalidad = readLine()
    print("Ingrese la fecha de nacimiento del director:  ")
    val fechaNacimiento = readLine()
    val director = Director(nombre!!, apellido!!, nacionalidad!!, Date(), emptyList())
    DirectorDAO().update(director)
}

private fun editarPelicula(
    pelicula: Pelicula,
    directorDAO: DirectorDAO,
    director: Director
) {
    println("Ingrese el nombre de la pelicula")
    val nombre = readLine()
    println("Ingrese el genero de la pelicula")
    val genero = readLine()
    println("Ingrese la fecha de la pelicula")
    val fechaEstreno = readLine()
    println("La pelicula solo se puede ver en cines")
    val soloEnCines = readLine()?.toBoolean()
    println("Ingrese el costo de la pelicula")
    val costo = readLine()?.toDouble()
    pelicula.titulo = nombre!!
    pelicula.genero = genero!!
    pelicula.fechaEstreno = Date()
    pelicula.soloEnCines = soloEnCines!!
    pelicula.precio = costo!!
    directorDAO.update(director)
}

fun llenarLista() {
    val directorDAO = DirectorDAO()
    val director1 = Director("Slayther", "Zamora", "Ecuatoriano", Date(), emptyList())
    val director2 = Director("Joshua", "Rodriguez", "Ecuatoriano", Date(), emptyList())
    val director3 = Director("Marcela", "Yanez", "Ecuatoriano", Date(), emptyList())
    val director4 = Director("Odalis", "Vera", "Ecuatoriano", Date(), emptyList())
    directorDAO.saveAll(listOf(director1, director2, director3, director4))
}