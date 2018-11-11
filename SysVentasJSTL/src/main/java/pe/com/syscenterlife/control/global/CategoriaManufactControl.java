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
import pe.com.syscenterlife.modelo.GloCategoriamanufact;

import pe.com.syscenterlife.servicio.global.CategoriamanufactServicioI;


/**
 *
 * @author LAB_SOFTWARE-DTI
 */
@Controller
public class CategoriaManufactControl {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    CategoriamanufactServicioI categoriaServicioI;

    
    Logger logger = Logger.getLogger(CategoriaManufactControl.class.getName());
//  MI LINK DE DONDE SE  CONECTARA  
@RequestMapping(value = {"/catManuMain" }, method = RequestMethod.GET)    
public ModelAndView inicioCategoria(Locale locale, Map<String,Object> model){
    String welcome=messageSource.getMessage("welcome.message", new Object[]{"Ulises Labra"}, locale);
    List<GloCategoriamanufact> lista=categoriaServicioI.listarEntidad();

    model.put("ListaCategoria", lista);
    model.put("message", welcome);
    model.put("startMeeting", "09:10");
    return new ModelAndView("global/categoriamanufactura/mainManufactura");
}

//A lOS QUE QUEIRO LINKEAR


//FUNCIONALIDAD
 
@RequestMapping(value = {"/buscarCategoria"}, method = RequestMethod.POST)
public  ModelAndView buscarEntidad(Locale locale, Map<String,Object> model, HttpServletRequest r){
        String welcome=messageSource.getMessage("welcome.message", new Object[]{"Ulises Labra"}, locale);
        String dato=r.getParameter("dato");
        List<GloCategoriamanufact> lista=categoriaServicioI.listarEntidadDato(dato);
        model.put("ListaCategoria", lista);
        model.put("message", welcome);
        model.put("startMeeting", "09:10");    
    return new ModelAndView("global/categoriamanufactura/mainManufactura");
    } 


 @RequestMapping(value = {"/elimCategoria" }, method = RequestMethod.GET)
    public ModelAndView eliminarPersona(HttpServletRequest r){
        int idEntidad=Integer.parseInt(r.getParameter("id"));
        categoriaServicioI.eliminarEntidad(idEntidad);
    return new ModelAndView(new RedirectView("/catManuMain"));
    }  

    @RequestMapping(value = "/Manuform", method = RequestMethod.GET)
    public ModelAndView irFormulario(@ModelAttribute("modeloCategoria")GloCategoriamanufact categoriamanufact,
        BindingResult result, Model model){
           List<GloCategoriamanufact> lista = categoriaServicioI.listarEntidad();
        model.addAttribute("urlAccion", "guardarCategoria");
        model.addAttribute("ListaCategoria", lista);
    return new ModelAndView("global/categoriamanufactura/formManufactura");
} 

      
    
   
@RequestMapping(value = "/guardarCategoria", method = RequestMethod.POST)
public ModelAndView guardarEntidad(@ModelAttribute("modeloCategoria")GloCategoriamanufact categoriamanufact,
        BindingResult result, Model model){
    
        try {
            if(categoriamanufact.getIdCategoriamanufactura()== null)
            categoriaServicioI.guardarEntidad(categoriamanufact);
	else
            categoriaServicioI.modificarEntidad(categoriamanufact);
        
     } catch (Exception e) { logger.info("ERRROR :"+e.getMessage());
     }  

    return new ModelAndView(new RedirectView("/catManuMain"));
} 

   @RequestMapping(value = {"/CategoriaModificar" }, method = RequestMethod.GET)
    public ModelAndView actualizarEntidad(HttpServletRequest r, Map<String,Object> model){
        int idEntidad=Integer.parseInt(r.getParameter("id"));       
        List<GloCategoriamanufact> lista = categoriaServicioI.listarEntidad();
        model.put("ListaCategoria", lista);
        model.put("modeloCategoria",categoriaServicioI.buscarEntidadId(idEntidad));
        model.put("urlAccion", "guardarCategoria");
        return new ModelAndView("global/categoriamanufactura/formManufactura");
    }
}

    