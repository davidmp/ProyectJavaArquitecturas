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
import pe.com.syscenterlife.modelo.GloAperturaPeriodo;
import pe.com.syscenterlife.servicio.global.AlmacenServicioI;
import pe.com.syscenterlife.servicio.global.AperturaPeriodoServicioI;
import pe.com.syscenterlife.servicio.global.ConfiguracionServicioI;
import pe.com.syscenterlife.servicio.global.PeriodoServicioI;

/**
 *
 * @author HEBERT
 */
@Controller
public class AperturaPeriodoControl {
        
    @Autowired
    private MessageSource messageSource;
    @Autowired
    AperturaPeriodoServicioI apperServicioI;
    @Autowired
    AlmacenServicioI almacenServicioI;
    @Autowired
    ConfiguracionServicioI configServicioI;
    @Autowired
    PeriodoServicioI periodoServicioI;
    

    @RequestMapping(value = {"/ApperMain" }, method = RequestMethod.GET)    
    public ModelAndView inicioApertura(Locale locale, Map<String,Object> model){
        List<GloAperturaPeriodo> lista=apperServicioI.listarEntidad();
        model.put("ListaApper", lista);       
        return new ModelAndView("global/aperturaperiodo/mainApper");
    } 
    
    @RequestMapping(value = {"/buscarApper"}, method = RequestMethod.POST)
    public  ModelAndView buscarEntidad(Locale locale, Map<String,Object> model, HttpServletRequest r){
        String dato=r.getParameter("dato");
        List<GloAperturaPeriodo> lista = apperServicioI.listarEntidadDato(dato);
        model.put("ListaApper", lista);
        return new ModelAndView("global/aperturaperiodo/mainApper");
    } 
    
    @RequestMapping(value = {"/deleteApper" }, method = RequestMethod.GET)
    public ModelAndView eliminarApertura(HttpServletRequest r){
        int idEntidad=Integer.parseInt(r.getParameter("id"));
        apperServicioI.eliminarEntidad(idEntidad);
        return new ModelAndView(new RedirectView("/ApperMain"));
    } 
    
    @RequestMapping(value = {"/updateApper" }, method = RequestMethod.GET)
    public ModelAndView editarApertura(HttpServletRequest r, Model model){
        int idEntidad=Integer.parseInt(r.getParameter("id"));
        model.addAttribute("modeloApper", apperServicioI.buscarEntidadId(idEntidad));
        model.addAttribute("ListAlmacen", almacenServicioI.listarEntidad());
        model.addAttribute("ListConfiguracion", configServicioI.listarEntidad()); 
        model.addAttribute("ListPeriodo", periodoServicioI.listarEntidad()); 
        return new ModelAndView("global/aperturaperiodo/formApper");
    } 
    
    @RequestMapping(value = "/formApper", method = RequestMethod.GET)
    public ModelAndView irFormu(@ModelAttribute("modeloApper")GloAperturaPeriodo apper,
        BindingResult result, Model model){
        model.addAttribute("ListAlmacen", almacenServicioI.listarEntidad());
        model.addAttribute("ListConfiguracion", configServicioI.listarEntidad()); 
        model.addAttribute("ListPeriodo", periodoServicioI.listarEntidad()); 
        return new ModelAndView("global/aperturaperiodo/formApper");
    }
    
    @RequestMapping(value = "/guardarApper", method = RequestMethod.POST)
        public ModelAndView guardarEntidad(@ModelAttribute("modeloApper")GloAperturaPeriodo apper,
        BindingResult result, HttpServletRequest r){
        try {
            if(apper.getIdAperturaPeriodo()==null)
                apperServicioI.guardarEntidad(apper);
            else
                apperServicioI.modificarEntidad(apper);
            return new ModelAndView(new RedirectView("/ApperMain"));
        } catch (Exception e) {    
            return new ModelAndView(new RedirectView("/formApper"));
        }    
}
}
