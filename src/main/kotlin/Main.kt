import model.dao.implementaciones.DirectorDAO
import model.entities.Director
import model.entities.Pelicula
import java.util.*

fun main(args: Array<String>) {

    llenarLista()
    val directorDAO = DirectorDAO()
    var opcion: Int

    do {
        opcion = showMenu()
        when (opcion) {
            1 -> insertarDirector()
            2 -> getDirectores()
            3 -> {
                getDirectores()
                print("Ingrese el numero del director a actualizar:  ")
                val numeroDirector = readLine()?.toInt()
                val directorAntiguo = directorDAO.getAll()[numeroDirector!! - 1]
                println("Informacion actual del director:  ${directorAntiguo.toString()}")
                actualizarDirector(directorAntiguo)
            }

            4 -> {
                getDirectores()
                print("Ingrese el numero del director a eliminar:  ")
                val numeroDirector = readLine()?.toInt()
                val director = directorDAO.getAll()[numeroDirector!! - 1]
                directorDAO.deleteById(director.id)
            }

            5 -> {
                println("Gracias por usar el programa")
                break
            }

            else -> println("Opcion no valida")
        }
    } while (opcion != 5)

}

private fun showMenu(): Int {
    println("¿Que accion desea realizar?")
    println("-------------------------------")
    println("1 - Insertar nuevo Director")
    println("2 - Ver lista de directores")
    println("3 - Actualizar director")
    println("4 - Eliminar director")
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

private fun actualizarDirector(directorAntiguo: Director) {
    print("Ingrese el nuevo nombre del director:  ")
    val nombre = readLine()
    print("Ingrese el nuevo apellido del director:  ")
    val apellido = readLine()
    print("Ingrese la nueva nacionalidad del director:  ")
    val nacionalidad = readLine()
    print("Ingrese la nueva fecha de nacimiento del director:  ")
    val fechaNacimiento = readLine()
    val directorNuevo = Director(nombre!!, apellido!!, nacionalidad!!, Date(), emptyList())
    DirectorDAO().update(directorAntiguo, directorNuevo)
}

fun llenarLista() {
    val directorDAO = DirectorDAO()
    val director1 = Director("Slayther", "Zamora", "Ecuatoriano", Date(), emptyList())
    val director2 = Director("Joshua", "Rodriguez", "Ecuatoriano", Date(), emptyList())
    val director3 = Director("Marcela", "Yanez", "Ecuatoriano", Date(), emptyList())
    val director4 = Director("Odalis", "Vera", "Ecuatoriano", Date(), emptyList())
    directorDAO.saveAll(listOf(director1, director2, director3, director4))
}