/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.control.global;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
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
import pe.com.syscenterlife.modelo.GloConfiguracion;
import pe.com.syscenterlife.servicio.global.ConfiguracionServicioI;



/**
 *
 * @author Juan Jose
 */
@Controller
public class ConfiguracionControl {
    @Autowired
    private MessageSource messageSource;
    @Autowired
    ConfiguracionServicioI configuracionServicioI;

    
    Logger logger = Logger.getLogger(ConfiguracionControl.class.getName());
    
@RequestMapping(value = {"/confiMain" }, method = RequestMethod.GET)    
public ModelAndView inicio(Locale locale, Map<String,Object> model){
    String welcome=messageSource.getMessage("welcome.message", new Object[]{"juan jose"}, locale);
    List<GloConfiguracion> lista=configuracionServicioI.listarEntidad();

    model.put("ListaConfiguracion", lista);
    model.put("message", welcome);
    model.put("startMeeting", "09:10");
    
    return new ModelAndView("global/configuracion/mainConfiguracion");
}





@RequestMapping(value = {"/elimConfi" }, method = RequestMethod.GET)
public ModelAndView eliminarConfiguracion(HttpServletRequest r){
    int idEntidad=Integer.parseInt(r.getParameter("id"));
    configuracionServicioI.eliminarEntidad(idEntidad);
return new ModelAndView(new RedirectView("/confiMain"));
}
  
@RequestMapping(value = {"/buscarConfi"}, method = RequestMethod.POST)
public  ModelAndView buscarEntidad(Locale locale, Map<String,Object> model, HttpServletRequest r){
    String welcome=messageSource.getMessage("welcome.message", new Object[]{"Juan José"}, locale);
    String dato=r.getParameter("dato");
    List<GloConfiguracion> lista=configuracionServicioI.listarEntidadDato(dato);
    model.put("ListaConfiguracion", lista);
    model.put("message", welcome);
    model.put("startMeeting", "09:10");    
return new ModelAndView("global/configuracion/mainConfiguracion");
}

@RequestMapping(value = "/formConfiguracion", method = RequestMethod.GET)
public ModelAndView irFormulario(@ModelAttribute("modeloConfiguracion")GloConfiguracion configuracion,
        BindingResult result, Model model){
    
        Map<String,String> idioma = new LinkedHashMap<String,String>();
        idioma.put("en", "Ingles");
        idioma.put("es", "Español");

        model.addAttribute("urlAccion", "guardarConfiguracion"); 
       
        model.addAttribute("ListIdioma", idioma); 
    return new ModelAndView("global/configuracion/formConfiguracion");
}

@RequestMapping(value = "/guardarConfiguracion", method = RequestMethod.POST)
public ModelAndView guardarEntidad(@ModelAttribute("modeloConfiguracion")GloConfiguracion configuracion,
        BindingResult result, HttpServletRequest r){
        try {
        configuracionServicioI.guardarEntidad(configuracion);
        return new ModelAndView(new RedirectView("/confiMain"));
        } catch (Exception e) { 
        logger.info("Error Guardar: "+e.getMessage());    
        return new ModelAndView(new RedirectView("/formConfiguracion"));
        }    
}

@RequestMapping(value = "/formModifConfiguracion", method = RequestMethod.GET)
public ModelAndView irModificarConfiguracion(HttpServletRequest r ){
   int id=Integer.parseInt(r.getParameter("id"));
       GloConfiguracion entidad=null;
       entidad=configuracionServicioI.buscarEntidadId(id);
    return new ModelAndView("global/configuracion/formConfiguracion","modeloConfiguracion",entidad);
}

@RequestMapping(value = "/formModif2Configuracion", method = RequestMethod.GET)
public String irModificar2Configuracion(HttpServletRequest r, Model model ){
   int id=Integer.parseInt(r.getParameter("id"));
       GloConfiguracion configuracion=null;
       configuracion=configuracionServicioI.buscarEntidadId(id);
       

        Map<String,String> idioma = new LinkedHashMap<String,String>();
        idioma.put("en", "Ingles");
        idioma.put("es", "Español");       
        model.addAttribute("modeloConfiguracion", configuracion);   
        model.addAttribute("ListIdioma", idioma);
        
        model.addAttribute("urlAccion", "actualizarConfiguracion");             
    return "global/configuraciion/formConfiguracion";
}

@RequestMapping(value = "actualizarConfiguracion", method = RequestMethod.POST)
public ModelAndView actualizarConfiguracion(@ModelAttribute("modeloConfiguracion") GloConfiguracion entidad,
                                      BindingResult result, HttpServletRequest r ){
        try {
        configuracionServicioI.modificarEntidad(entidad);
        return new ModelAndView(new RedirectView(r.getContextPath()+"/confiMain"));
    } catch (Exception e) {
        logger.info("Error al modificar: "+e.getMessage());
        return new ModelAndView(new RedirectView(r.getContextPath()+"/formModif2Configuracion?id="+entidad.getIdCuentaIgv()));
    }
    
}

}
