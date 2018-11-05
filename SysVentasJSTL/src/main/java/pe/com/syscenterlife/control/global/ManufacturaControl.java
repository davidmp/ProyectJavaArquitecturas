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
import pe.com.syscenterlife.modelo.GloManufactura;
import pe.com.syscenterlife.servicio.global.ManufacturaServicioI;

/**
 *
 * @author edwil
 */
@Controller
public class ManufacturaControl {
    
    @Autowired
    private MessageSource messageSource;
    @Autowired
    ManufacturaServicioI manufacturaServicioI;
    
    Logger logger = Logger.getLogger(ManufacturaControl.class.getName());
    
@RequestMapping(value = {"/manuMain" }, method = RequestMethod.GET)    
public ModelAndView inicio(Locale locale, Map<String,Object> model){
    String welcome=messageSource.getMessage("welcome.message", new Object[]{"Wilson Mamani"}, locale);
    List<GloManufactura> lista=manufacturaServicioI.listarEntidad();

    model.put("ListaManufactura", lista);
    model.put("message", welcome);
    model.put("startMeeting", "09:10");
    
    return new ModelAndView("global/manufactura/mainManufactura");
}





@RequestMapping(value = {"/elimManu" }, method = RequestMethod.GET)
public ModelAndView eliminarManufactura(HttpServletRequest r){
    int idEntidad=Integer.parseInt(r.getParameter("id"));
    manufacturaServicioI.eliminarEntidad(idEntidad);
return new ModelAndView(new RedirectView("/manuMain"));
}
  
@RequestMapping(value = {"/buscarManu"}, method = RequestMethod.POST)
public  ModelAndView buscarEntidad(Locale locale, Map<String,Object> model, HttpServletRequest r){
    String welcome=messageSource.getMessage("welcome.message", new Object[]{"David Mamani"}, locale);
    String dato=r.getParameter("dato");
    List<GloManufactura> lista=manufacturaServicioI.listarEntidadDato(dato);
    model.put("ListaManufactura", lista);
    model.put("message", welcome);
    model.put("startMeeting", "09:10");    
return new ModelAndView("global/manufactura/mainManufactura");
}
@RequestMapping(value = "/formManufactura", method = RequestMethod.GET)
public ModelAndView irFormulario(@ModelAttribute("modeloManufactura")GloManufactura manufactura,
        BindingResult result, Model model){
        Map<String,String> tipo = new LinkedHashMap<String,String>();
        tipo.put("E", "telas");
        tipo.put("F", "franelas");

        Map<String,String> categori = new LinkedHashMap<String,String>();
        categori.put("L", "lana");
        categori.put("A", "algodon");

        model.addAttribute("urlAccion", "guardarManufactura"); 
        model.addAttribute("ListTipo", tipo); 
        model.addAttribute("ListCategori", categori); 
    return new ModelAndView("global/manufactura/formManufactura");
}

@RequestMapping(value = "/guardarManufactura", method = RequestMethod.POST)
public ModelAndView guardarEntidad(@ModelAttribute("modeloManufactura")GloManufactura manufactura,
        BindingResult result, HttpServletRequest r){
        logger.info("Error Estado: "+manufactura.getEstado());
        try {
        manufacturaServicioI.guardarEntidad(manufactura);
        return new ModelAndView(new RedirectView("/manuMain"));
        } catch (Exception e) { 
        logger.info("Error guardarManufactura: "+e.getMessage());    
        return new ModelAndView(new RedirectView("/formManufactura"));
        }    
}

@RequestMapping(value = "/formModifManufactura", method = RequestMethod.GET)
public ModelAndView irModificarManufactura(HttpServletRequest r ){
   int id=Integer.parseInt(r.getParameter("id"));
       GloManufactura entidad=null;
       entidad=manufacturaServicioI.buscarEntidadId(id);
    return new ModelAndView("global/manufactura/formManufactura","modeloManufactura",entidad);
}

@RequestMapping(value = "/formModif2Manufactura", method = RequestMethod.GET)
public String irModificar2Manufactura(HttpServletRequest r, Model model ){
   int id=Integer.parseInt(r.getParameter("id"));
       GloManufactura manufactura=null;
       manufactura=manufacturaServicioI.buscarEntidadId(id);
       logger.info("Error Estado Real "+manufactura.getEstado());

        Map<String,String> tipo = new LinkedHashMap<String,String>();
        tipo.put("T", "tela");
        tipo.put("F", "franelas");

        Map<String,String> categori = new LinkedHashMap<String,String>();
        categori.put("L", "lana");
        categori.put("A", "Algodon");       
        model.addAttribute("modeloManufactura", manufactura);  
         
        model.addAttribute("ListCategori", categori);
        
        model.addAttribute("urlAccion", "actualizarManufactura");             
    return "global/manufactura/formManufactura";
}

@RequestMapping(value = "actualizarManufactura", method = RequestMethod.POST)
public ModelAndView actualizarManufactura(@ModelAttribute("modeloManufactura") GloManufactura entidad,
                                      BindingResult result, HttpServletRequest r ){
        try {
        manufacturaServicioI.modificarEntidad(entidad);
        return new ModelAndView(new RedirectView(r.getContextPath()+"/manuMain"));
    } catch (Exception e) {
        logger.info("Error al modificar: "+e.getMessage());
        return new ModelAndView(new RedirectView(r.getContextPath()+"/formModif2Manufactura?id="+entidad.getIdManufactura()));
    }
    
}
}
