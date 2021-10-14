package bmc.care.dao;

import bmc.care.dto.dataMaestra.DataMaestra;
import bmc.care.exception.DaoException;

import java.util.List;


public interface DataMaestraDao {
    DataMaestra saveDataMaestra(DataMaestra dataMaestra) throws DaoException;
    DataMaestra update(DataMaestra dataMaestra)  throws DaoException;
    void deleteByIdDataMaestra(int id) throws DaoException;
    List<DataMaestra> ConsultDataMaestraById(int id) throws DaoException;
    public List<DataMaestra> consultDataMaestraByTipo(String codigo) throws DaoException;
    int exist(DataMaestra dm)  throws DaoException;
}
