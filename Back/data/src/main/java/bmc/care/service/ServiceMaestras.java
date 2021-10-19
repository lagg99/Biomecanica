package bmc.care.service;

import bmc.care.dto.maestras.Maestras;
import bmc.care.exception.ServiceException;

import java.util.List;

public interface ServiceMaestras {
    Maestras save(Maestras maestras) throws ServiceException;
    void delete(int id) throws ServiceException ;
    Maestras getById(int id) throws ServiceException ;
    List<Maestras> getAll() throws ServiceException ;
}
