package bmc.care.controller;

import bmc.care.dto.maestras.Maestras;
import bmc.care.exception.ServiceException;
import bmc.care.service.ServiceMaestras;
import bmc.care.service.ServiceMaestrasImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bmc/maestras") //  http://localhost:1020/swagger-ui/#/
@CrossOrigin(origins = "http://localhost:4600", maxAge = 3600)// esto es para poder mostrar en from
public class ControllerMaestras {

    private final Logger logger =  LoggerFactory.getLogger(ControllerMaestras.class);

    @Autowired
    ServiceMaestras serviceMaestras;

    @PostMapping("/saveOrUpdateMaestra")
    public Maestras save(@RequestBody Maestras maestras){
        Maestras returnData=null;
        try{
            returnData= serviceMaestras.save(maestras);
        }catch (ServiceException se){
            logger.error(ServiceException.toStringStackTrace(se));
        }catch (Exception ex){
            logger.error(ServiceException.toStringStackTrace(ex));
        }
        return returnData;
    }

    @DeleteMapping("/deleteMaestrasById/{id}")
    public @ResponseBody String delete(@PathVariable ("id") int nmmaestro ){
        try {
            serviceMaestras.delete(nmmaestro);
        }catch (ServiceException se){
            logger.error(ServiceException.toStringStackTrace(se));
        }catch (Exception ex){
            logger.error(ServiceException.toStringStackTrace(ex));
        }
        return "{\"delete\" : \"eliminado\"}";

    }

    @GetMapping("/getMaestraById/{id}")
    public Maestras getById(@PathVariable ("id")  int nmmaestro){
        Maestras returnData=null;
        try{
            returnData= serviceMaestras.getById(nmmaestro);
        }catch (ServiceException se){
            logger.error(ServiceException.toStringStackTrace(se));
        }catch (Exception ex){
            logger.error(ServiceException.toStringStackTrace(ex));
        }
        return returnData;

    }
    @GetMapping("/getAll")
    public List<Maestras> getAll(){
        List<Maestras> lista =null;
        try{
            lista= serviceMaestras.getAll();
        }catch (ServiceException se){
            logger.error(ServiceException.toStringStackTrace(se));
        }catch (Exception ex){
            logger.error(ServiceException.toStringStackTrace(ex));

        }
        return lista;
    }
}
