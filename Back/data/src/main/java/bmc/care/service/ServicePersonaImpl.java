package bmc.care.service;

import bmc.care.dao.PersonasDao;
import bmc.care.dto.Persona;
import bmc.care.exception.DaoException;
import bmc.care.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class ServicePersonaImpl implements ServicePersona{

    @Autowired
    private PersonasDao personasDao;

    @Override
    public Persona save(Persona persona) throws ServiceException {
        try {
            return personasDao.save(persona);
        }catch (DaoException de){
            throw new ServiceException(de);
        }catch (Exception ex){
            throw new ServiceException(ex);
        }

    }
}
