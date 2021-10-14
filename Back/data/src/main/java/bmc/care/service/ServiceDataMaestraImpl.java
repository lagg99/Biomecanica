package bmc.care.service;

import bmc.care.dao.DataMaestraDaoImpl;
import bmc.care.dto.dataMaestra.DataMaestra;
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
public class ServiceDataMaestraImpl implements ServiceDataMaestra {


    private final Logger log = LoggerFactory.getLogger(ServiceDataMaestraImpl.class);

    @Autowired
    private DataMaestraDaoImpl dataMaestraDao;

    @Override
    public DataMaestra saveDataMaestra(DataMaestra dataMaestra) throws ServiceException {
        try{
            return dataMaestraDao.saveDataMaestra(dataMaestra);
        }catch (DaoException de){
            throw new ServiceException(de);
        }catch (Exception ex){
            throw new ServiceException(ex);

        }

    }

    @Override
    public void deleteByIdDataMaestra(int id) throws ServiceException {
        try{
            dataMaestraDao.deleteByIdDataMaestra(id);
        }catch (DaoException de){
            throw new ServiceException(de);
        }catch (Exception ex){
            throw new ServiceException(ex);

        }

    }

    @Override
    public List<DataMaestra> ConsultByIdDataMaestra(int id) throws ServiceException{

        try{
            return dataMaestraDao.ConsultDataMaestraById(id);
        }catch (DaoException de){
            throw new ServiceException(de);
        }catch (Exception ex){
            throw new ServiceException(ex);

        }

    }

    @Override
    public List<DataMaestra> consultDataMaestraByTipo(String codigo) throws ServiceException {
        try{
            return dataMaestraDao.consultDataMaestraByTipo(codigo);
        }catch (DaoException de){
            throw new ServiceException(de);
        }catch (Exception ex){
            throw new ServiceException(ex);

        }

    }

    @Override
    public DataMaestra update(DataMaestra dataMaestra) throws ServiceException {
        try{
            return dataMaestraDao.update(dataMaestra);
        }catch (DaoException de){
            throw new ServiceException(de);
        }catch (Exception ex){
            throw new ServiceException(ex);

        }


    }


}
