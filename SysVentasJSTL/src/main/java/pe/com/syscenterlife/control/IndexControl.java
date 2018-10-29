/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.control;

import java.util.Locale;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pe.com.syscenterlife.servicio.global.PersonaServicioI;

/**
 *
 * @author davidmp
 */
@Controller
public class IndexControl {
    @Autowired
    private MessageSource messageSource;
    @Autowired
    PersonaServicioI personaServicioI;

   @RequestMapping(value = "/locate", method = RequestMethod.GET)
    public String getLocatePage(){
    return "my-locale";
    }
    
    @RequestMapping(value = {"/" }, method = RequestMethod.GET)    
    public ModelAndView inicioLoginForm(Locale locale, Map<String,Object> model){
        return new ModelAndView("index");
    }
    @RequestMapping(value = {"/validate" }, method = RequestMethod.POST)    
    public ModelAndView inicioLoginValidate(Locale locale, Map<String,Object> model){
        return new ModelAndView("global/home");
    }
    @RequestMapping(value = {"/idiom" }, method = RequestMethod.GET)    
    public ModelAndView inicioIdioma(Locale locale, Map<String,Object> model){
        return new ModelAndView("global/home");
    }
    
}
