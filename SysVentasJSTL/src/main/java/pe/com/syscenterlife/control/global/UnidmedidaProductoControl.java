/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.control.global;


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
import pe.com.syscenterlife.modelo.GloProductos;
import pe.com.syscenterlife.modelo.GloUnidadMedida;

import pe.com.syscenterlife.modelo.GloUnidadmedProducto;
import pe.com.syscenterlife.servicio.global.ProductoServicioI;
import pe.com.syscenterlife.servicio.global.UmedidaproductoServicioI;
import pe.com.syscenterlife.servicio.global.UnidadmedidaServicioI;

/**
 *
 * @author quiroga
 */
@Controller
public class UnidmedidaProductoControl {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    UmedidaproductoServicioI UmedidaproductoServicioI;
    @Autowired
    UnidadmedidaServicioI unidadmedidaServicioI;
    @Autowired
    ProductoServicioI productoServicioI;

    Logger logger = Logger.getLogger(UnidmedidaProductoControl.class.getName());

    @RequestMapping(value = {"/prodMain"}, method = RequestMethod.GET)
    public ModelAndView inicioProducto(Locale locale, Map<String, Object> model) {
        String welcome = messageSource.getMessage("welcome.message", new Object[]{"-A-N-O-N-Y-M-O-U-S-"}, locale);
        List<GloUnidadmedProducto> lista = UmedidaproductoServicioI.listarEntidad();

        model.put("ListaUniMediProducto", lista);
        model.put("message", welcome);
        model.put("startMeeting", "09:10");
        return new ModelAndView("global/unidadmediproducto/mainUniMedProducto");
    }
    
  
  @RequestMapping(value = {"/buscarump"}, method = RequestMethod.POST)
    public  ModelAndView buscarEntidad(Map<String,Object> model, HttpServletRequest r, @ModelAttribute("modeloump")GloUnidadmedProducto ump,
        BindingResult result){
        String dato=r.getParameter("dato");
        List<GloUnidadmedProducto> lista=UmedidaproductoServicioI.listarEntidadDato(dato);
        model.put("ListaUniMediProducto", lista);
        model.put("noresults", "No matches were found.");
        model.put("accion", "Add...");
        return new ModelAndView("global/unidadmediproducto/mainUniMedProducto");
    } 

    @RequestMapping(value = {"/elimump"}, method = RequestMethod.GET)
    public ModelAndView eliminarPersona(HttpServletRequest r) {
        int idEntidad = Integer.parseInt(r.getParameter("id"));
        UmedidaproductoServicioI.eliminarEntidad(idEntidad);
        return new ModelAndView(new RedirectView("/prodMain"));
    }

    @RequestMapping(value = "/formump", method = RequestMethod.GET)
    public ModelAndView irFormulario(@ModelAttribute("modeloump") GloUnidadmedProducto ump,
            BindingResult result, Map<String,Object> model) {
        List<GloUnidadMedida> Umedida = unidadmedidaServicioI.listarEntidad();
        model.put("urlAccion", "guardarUMP");
        model.put("ListarUnidadMedida", Umedida);
//
        List<GloProductos> producto = productoServicioI.listarEntidad();
        model.put("ListaProducto", producto);
        return new ModelAndView("global/unidadmediproducto/formUnimPro");
    }
//
 @RequestMapping(value = "/guardarUMP", method = RequestMethod.POST)
    public ModelAndView guardarEntidad(@ModelAttribute("modeloump") GloUnidadmedProducto ump, BindingResult result, Model model){        
        
     try {
            if(ump.getIdUnidMedProducto()== null)
            UmedidaproductoServicioI.guardarEntidad(ump);
	else
            UmedidaproductoServicioI.modificarEntidad(ump);
        
     } catch (Exception e) { logger.info("ERRROR :"+e.getMessage());
     }
     return new ModelAndView(new RedirectView("/prodMain"));
    } 

    
      @RequestMapping(value = {"/formModifump" }, method = RequestMethod.GET)
    public ModelAndView actualizarEntidad(HttpServletRequest r, Map<String,Object> model){
        int idEntidad=Integer.parseInt(r.getParameter("id"));       
        List<GloUnidadmedProducto> lista = UmedidaproductoServicioI.listarEntidad();
        model.put("ListaUniMediProducto", lista);
        model.put("modeloump",UmedidaproductoServicioI.buscarEntidadId(idEntidad));
        model.put("accion", "Edit...");
        List<GloUnidadMedida> Umedida = unidadmedidaServicioI.listarEntidad();
        model.put("urlAccion", "guardarUMP");
        model.put("ListarUnidadMedida", Umedida);
//
        List<GloProductos> producto = productoServicioI.listarEntidad();
        model.put("ListaProducto", producto);
        return new ModelAndView("global/unidadmediproducto/formUnimPro");
    }
}
