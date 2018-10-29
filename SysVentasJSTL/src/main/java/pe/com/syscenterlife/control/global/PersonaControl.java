/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.control.global;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import pe.com.syscenterlife.modelo.GloPersonas;
import pe.com.syscenterlife.servicio.global.PersonaServicioI;


/**
 *
 * @author LAB_SOFTWARE-DTI
 */
@Controller
public class PersonaControl {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    PersonaServicioI personaServicioI;

    
    Logger logger = Logger.getLogger(PersonaControl.class.getName());
    
@RequestMapping(value = {"/perMain" }, method = RequestMethod.GET)    
public ModelAndView inicio(Locale locale, Map<String,Object> model){
    String welcome=messageSource.getMessage("welcome.message", new Object[]{"David Mamani"}, locale);
    List<GloPersonas> lista=personaServicioI.listarEntidad();

    model.put("ListaPersona", lista);
    model.put("message", welcome);
    model.put("startMeeting", "09:10");
    
    return new ModelAndView("global/persona/mainPersona");
}




@RequestMapping(value = {"/pru1" }, method = RequestMethod.GET)    
public ModelAndView inicioUno(){
    
    return new ModelAndView("global/Prueba2");
}
@RequestMapping(value = {"/pru2" }, method = RequestMethod.GET)    
public ModelAndView inicioDos(){
    
    return new ModelAndView("global/Prueba3");
}

@RequestMapping(value = {"/pers" }, method = RequestMethod.GET)    
public ModelAndView mainPersona(){    
    return new ModelAndView("global/persona/mainPersona");
}
@RequestMapping(value = {"/report" }, method = RequestMethod.GET)    
public ModelAndView mainPersonaReport(){    
    return new ModelAndView("global/persona/reporte/reportePersona");
}

@RequestMapping(value = {"/elim" }, method = RequestMethod.GET)
public ModelAndView eliminarPersona(HttpServletRequest r){
    int idEntidad=Integer.parseInt(r.getParameter("id"));
    personaServicioI.eliminarEntidad(idEntidad);
return new ModelAndView(new RedirectView("/perMain"));
}
  
@RequestMapping(value = {"/buscar"}, method = RequestMethod.POST)
public  ModelAndView buscarEntidad(Locale locale, Map<String,Object> model, HttpServletRequest r){
    String welcome=messageSource.getMessage("welcome.message", new Object[]{"David Mamani"}, locale);
    String dato=r.getParameter("dato");
    List<GloPersonas> lista=personaServicioI.listarEntidadDato(dato);
    model.put("ListaPersona", lista);
    model.put("message", welcome);
    model.put("startMeeting", "09:10");    
return new ModelAndView("global/persona/mainPersona");
}

@RequestMapping(value = "/formPersona", method = RequestMethod.GET)
public ModelAndView irFormulario(@ModelAttribute("modeloPersona")GloPersonas persona,
        BindingResult result, Model model){
        Map<String,String> genero = new LinkedHashMap<String,String>();
        genero.put("F", "Femenino");
        genero.put("M", "Masculino");

        Map<String,String> idioma = new LinkedHashMap<String,String>();
        idioma.put("en", "Ingles");
        idioma.put("es", "Español");

        model.addAttribute("urlAccion", "guardarPersona"); 
        model.addAttribute("ListGenero", genero); 
        model.addAttribute("ListIdioma", idioma); 
    return new ModelAndView("global/persona/formPersona");
}

@RequestMapping(value = "/guardarPersona", method = RequestMethod.POST)
public ModelAndView guardarEntidad(@ModelAttribute("modeloPersona")GloPersonas persona,
        BindingResult result, HttpServletRequest r){
        logger.info("Error Fecha: "+persona.getFechaNacimiento());
        try {
        personaServicioI.guardarEntidad(persona);
        return new ModelAndView(new RedirectView("/perMain"));
        } catch (Exception e) { 
        logger.info("Error Guardar: "+e.getMessage());    
        return new ModelAndView(new RedirectView("/formPersona"));
        }    
}

@RequestMapping(value = "/formModifPersona", method = RequestMethod.GET)
public ModelAndView irModificarPersona(HttpServletRequest r ){
   int id=Integer.parseInt(r.getParameter("id"));
       GloPersonas entidad=null;
       entidad=personaServicioI.buscarEntidadId(id);
    return new ModelAndView("global/persona/formPersona","modeloPersona",entidad);
}

@RequestMapping(value = "/formModif2Persona", method = RequestMethod.GET)
public String irModificar2Persona(HttpServletRequest r, Model model ){
   int id=Integer.parseInt(r.getParameter("id"));
       GloPersonas persona=null;
       persona=personaServicioI.buscarEntidadId(id);
       logger.info("Error Fecha Real "+persona.getFechaNacimiento());

        Map<String,String> genero = new LinkedHashMap<String,String>();
        genero.put("F", "Femenino");
        genero.put("M", "Masculino");

        Map<String,String> idioma = new LinkedHashMap<String,String>();
        idioma.put("en", "Ingles");
        idioma.put("es", "Español");       
        model.addAttribute("modeloPersona", persona);  
        model.addAttribute("ListGenero", genero); 
        model.addAttribute("ListIdioma", idioma);
        
        model.addAttribute("urlAccion", "actualizarPersona");             
    return "global/persona/formPersona";
}

@RequestMapping(value = "actualizarPersona", method = RequestMethod.POST)
public ModelAndView actualizarPersona(@ModelAttribute("modeloPersona") GloPersonas entidad,
                                      BindingResult result, HttpServletRequest r ){
        try {
        personaServicioI.modificarEntidad(entidad);
        return new ModelAndView(new RedirectView(r.getContextPath()+"/perMain"));
    } catch (Exception e) {
        logger.info("Error al modificar: "+e.getMessage());
        return new ModelAndView(new RedirectView(r.getContextPath()+"/formModif2Persona?id="+entidad.getIdPersona()));
    }
    
}

}
