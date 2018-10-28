/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.academico.control;

import java.util.List;
import java.util.Locale;
import java.util.Map;
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
import pe.edu.upeu.academico.modelo.Persona;
import pe.edu.upeu.academico.servicio.PersonaServicioI;

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
    
    @RequestMapping(value = "/locate", method = RequestMethod.GET)
    public String getLocatePage(){
    return "my-locale";
    }
    
    
@RequestMapping(value = {"/perMain" }, method = RequestMethod.GET)    
public ModelAndView inicio(Locale locale, Map<String,Object> model){
    String welcome=messageSource.getMessage("welcome.message", new Object[]{"David Mamani"}, locale);
    List<Persona> lista=personaServicioI.listarEntidad();
    for (Persona persona : lista) {
        System.out.println("Nombres: "+persona.getNombre()+" "+persona.getApellidos());
    }
    model.put("ListaPersona", lista);
    model.put("message", welcome);
    model.put("startMeeting", "09:10");
    
    return new ModelAndView("global/persona/mainPersona");
}

@RequestMapping(value = {"/" }, method = RequestMethod.GET)    
public ModelAndView inicioLoginForm(Locale locale, Map<String,Object> model){
    return new ModelAndView("index");
}
@RequestMapping(value = {"/validate" }, method = RequestMethod.POST)    
public ModelAndView inicioLoginValidate(Locale locale, Map<String,Object> model){
    return new ModelAndView("global/home");
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
    List<Persona> lista=personaServicioI.listarEntidadDato(dato);
    model.put("ListaPersona", lista);
    model.put("message", welcome);
    model.put("startMeeting", "09:10");    
return new ModelAndView("global/persona/mainPersona");
}

@RequestMapping(value = "/formPersona", method = RequestMethod.GET)
public ModelAndView irFormulario(@ModelAttribute("modeloPersona")Persona persona,
        BindingResult result, Model model){
    model.addAttribute("urlAccion", "guardarPersona"); 
return new ModelAndView("global/persona/formPersona");
}

@RequestMapping(value = "/guardarPersona", method = RequestMethod.POST)
public ModelAndView guardarEntidad(@ModelAttribute("modeloPersona")Persona persona,
        BindingResult result){
        personaServicioI.guardarEntidad(persona);
    return new ModelAndView(new RedirectView("/"));
}

@RequestMapping(value = "/formModifPersona", method = RequestMethod.GET)
public ModelAndView irModificarPersona(HttpServletRequest r ){
   int id=Integer.parseInt(r.getParameter("id"));
       Persona entidad=null;
       entidad=personaServicioI.buscarEntidadId(id);
    return new ModelAndView("global/persona/formPersona","modeloPersona",entidad);
}

@RequestMapping(value = "/formModif2Persona", method = RequestMethod.GET)
public String irModificar2Persona(HttpServletRequest r, Model model ){
   int id=Integer.parseInt(r.getParameter("id"));
       Persona persona=null;
       persona=personaServicioI.buscarEntidadId(id);
       model.addAttribute("modeloPersona", persona);             
       model.addAttribute("urlAccion", "actualizarPersona");             
    return "global/persona/formPersona";
}

@RequestMapping(value = "actualizarPersona", method = RequestMethod.POST)
public ModelAndView actualizarPersona(@ModelAttribute("modeloPersona") Persona entidad,
                                      BindingResult result, HttpServletRequest r ){
        personaServicioI.modificarEntidad(entidad);
    return new ModelAndView(new RedirectView(r.getContextPath()+"/perMain"));
}

}
