package bmc.care.service;

import bmc.care.dao.MaestrasDaoImpl;
import bmc.care.dto.maestras.Maestras;
import bmc.care.exception.DaoException;
import bmc.care.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ServiceMaestrasImpl implements ServiceMaestras{

    private final Logger logger =  LoggerFactory.getLogger(ServiceMaestrasImpl.class);

    @Autowired
    MaestrasDaoImpl maestrasDao;

    @Override
    public Maestras save(Maestras maestras) throws ServiceException {
        try {
            if(maestrasDao.exist(maestras)==0){
                return  maestrasDao.save(maestras);
            }else {
                return maestrasDao.update(maestras);
            }
        }catch (DaoException de){
            throw new  ServiceException(de);
        }catch(Exception ex) {
            throw new  ServiceException(ex);

        }

    }

    @Override
    public void delete(int id) throws ServiceException {
        try {
            maestrasDao.delete(id);

        }catch (DaoException de){
            throw new  ServiceException(de);
        }catch(Exception ex) {
            throw new  ServiceException(ex);

        }

    }

    @Override
    public Maestras getById(int id)  throws ServiceException{
        try {
            return maestrasDao.getById(id);
        }catch (DaoException de){
            throw new  ServiceException(de);
        }catch(Exception ex) {
            throw new  ServiceException(ex);

        }

    }

    @Override
    public List<Maestras> getAll() throws ServiceException {
        try {
            return maestrasDao.getAll();
        }catch (DaoException de){
            throw new  ServiceException(de);
        }catch(Exception ex) {
            throw new  ServiceException(ex);

        }

    }



}