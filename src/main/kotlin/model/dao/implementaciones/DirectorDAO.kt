package model.dao.implementaciones

import model.dao.interfaces.ICrudDAO
import model.dao.interfaces.IDirectorDAO
import model.entities.Director

class DirectorDAO: CrudDAO<Director, Int>(Director::class.java), IDirectorDAO{

}