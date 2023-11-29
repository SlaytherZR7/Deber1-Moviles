package model.dao.interfaces

import model.dao.implementaciones.FactoryDAOImpl

abstract class FactoryDAO {
    companion object {
        private val factory: FactoryDAO = FactoryDAOImpl()

        @JvmStatic
        fun getFactory(): FactoryDAO {
            return factory
        }
    }

    abstract fun getDirectorDAO(): IDirectorDAO

    abstract fun getPeliculaDAO(): IPeliculaDAO
}