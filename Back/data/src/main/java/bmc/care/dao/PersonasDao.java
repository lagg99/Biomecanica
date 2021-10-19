package bmc.care.dao;

import bmc.care.dto.Persona;
import bmc.care.exception.DaoException;

public interface PersonasDao {
    Persona save(Persona persona) throws DaoException;
}
