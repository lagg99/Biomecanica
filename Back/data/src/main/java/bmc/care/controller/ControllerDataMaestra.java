package bmc.care.controller;


import bmc.care.dto.dataMaestra.DataMaestra;
import bmc.care.dto.maestras.Maestras;
import bmc.care.exception.DaoException;
import bmc.care.exception.ServiceException;
import bmc.care.service.ServiceDataMaestra;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bmc/datamaestra")
@CrossOrigin(origins = "http://localhost:4600", maxAge = 3600)// esto es para poder mostrar en from
public class ControllerDataMaestra {
    private final Logger logger =  LoggerFactory.getLogger(ControllerDataMaestra.class);
    @Autowired
    private ServiceDataMaestra serviceDataMaestra;

    @PostMapping("/savedDataMaestra")
    public @ResponseBody DataMaestra saveDataMaestra(@RequestBody DataMaestra dataMaestra)  {
        DataMaestra data=null;
        try{
            data=  serviceDataMaestra.saveDataMaestra(dataMaestra);
        }catch (ServiceException se){
            logger.error(ServiceException.toStringStackTrace(se));
        }catch (Exception ex){
            logger.error(ServiceException.toStringStackTrace(ex));


        }
        return  data;



    }

    @DeleteMapping("/deleteDataMaestra/{id}")
    public @ResponseBody String delete(@PathVariable("id")int id){
        try{
              serviceDataMaestra.deleteByIdDataMaestra(id);
        }catch (ServiceException se){
            logger.error(ServiceException.toStringStackTrace(se));
        }catch (Exception ex){
            logger.error(ServiceException.toStringStackTrace(ex));

        }
        return "Removed";
    }

    @GetMapping("/getDataMaestra/{id}")
    public List<DataMaestra> ConsultDataMaestraById(@PathVariable ("id")int id){
        List<DataMaestra> lista = null;

        try{
            lista= serviceDataMaestra.ConsultByIdDataMaestra(id);
        }catch (ServiceException se){
            logger.error(ServiceException.toStringStackTrace(se));
        }catch (Exception ex){
            logger.error(ServiceException.toStringStackTrace(ex));

        }
        return lista;

    }

    @GetMapping("/consultDataMaestraByTipo/{codigo}")
    public List<DataMaestra> consultDataMaestraByTipo(@PathVariable ("codigo")String codigo){
        List<DataMaestra> lista = null;

        try{
            lista= serviceDataMaestra.consultDataMaestraByTipo(codigo);
        }catch (ServiceException se){
            logger.error(ServiceException.toStringStackTrace(se));
        }catch (Exception ex){
            logger.error(ServiceException.toStringStackTrace(ex));

        }
        return lista;

    }

    @PutMapping("/update/{id}")
    public DataMaestra update(@RequestBody DataMaestra dataMaestra, @PathVariable ("id")int id)  {
        DataMaestra data=null;
        try{
            data= serviceDataMaestra.update(dataMaestra);
        }catch (ServiceException se){
            logger.error(ServiceException.toStringStackTrace(se));
        }catch (Exception ex) {
            logger.error(ServiceException.toStringStackTrace(ex));
        }
        return data;
    }
}