package bmc.care.service;

import bmc.care.dto.dataMaestra.DataMaestra;
import bmc.care.exception.DaoException;
import bmc.care.exception.ServiceException;

import java.util.List;


public interface ServiceDataMaestra {
     DataMaestra saveDataMaestra(DataMaestra dataMaestra) throws ServiceException;
     void deleteByIdDataMaestra(int id) throws ServiceException;
     List<DataMaestra> ConsultByIdDataMaestra(int id) throws ServiceException;
      List<DataMaestra> consultDataMaestraByTipo(String codigo) throws ServiceException;
     DataMaestra update(DataMaestra dataMaestra) throws  ServiceException;

}
