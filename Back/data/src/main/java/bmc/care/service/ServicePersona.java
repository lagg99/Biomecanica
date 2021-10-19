package bmc.care.service;

import bmc.care.dto.Persona;
import bmc.care.exception.DaoException;
import bmc.care.exception.ServiceException;

public interface ServicePersona {
    Persona save (Persona persona) throws ServiceException;
}
