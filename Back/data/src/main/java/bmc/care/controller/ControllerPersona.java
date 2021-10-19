package bmc.care.controller;

import bmc.care.dto.Persona;
import bmc.care.exception.ServiceException;
import bmc.care.service.ServicePersona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bmc/persona")
@CrossOrigin(origins = "http://localhost:4600", maxAge = 3600)// esto es para poder mostrar en from
public class ControllerPersona {

    private final Logger logger =  LoggerFactory.getLogger(ControllerPersona.class);

    @Autowired
    ServicePersona servicePersona;

    @PostMapping("/save")
    public Persona savePersona(@RequestBody Persona persona){
        Persona data=null;
        try{
            data=servicePersona.save(persona);
        }catch (ServiceException se){
            logger.error(ServiceException.toStringStackTrace(se));
        }catch (Exception ex){
            logger.error(ServiceException.toStringStackTrace(ex));
        }
        return data;
    }
    }

