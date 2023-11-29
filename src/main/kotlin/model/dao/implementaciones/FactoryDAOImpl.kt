package model.dao.implementaciones

import model.dao.interfaces.FactoryDAO
import model.dao.interfaces.IDirectorDAO
import model.dao.interfaces.IPeliculaDAO

class FactoryDAOImpl : FactoryDAO() {
    override fun getDirectorDAO(): IDirectorDAO {
        return DirectorDAO()
    }

    override fun getPeliculaDAO(): IPeliculaDAO {
        return PeliculaDAO()
    }
}