package bmc.care.dao;

import bmc.care.dto.maestras.Maestras;
import bmc.care.exception.DaoException;

import java.util.List;

public interface MaestrasDao {
    Maestras save(Maestras maestras) throws DaoException;
    Maestras update(Maestras maestras)  throws DaoException;
    void delete(int id)  throws DaoException;
    Maestras getById(int id)  throws DaoException;
    List<Maestras> getAll()  throws DaoException;
    int exist(Maestras maestras)  throws DaoException;
}
