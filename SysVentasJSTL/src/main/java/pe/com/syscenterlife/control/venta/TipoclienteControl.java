/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.control.venta;

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
import pe.com.syscenterlife.modelo.VentTipoCliente;
import pe.com.syscenterlife.servicio.venta.TipoclienteServicioI;



@Controller
public class TipoclienteControl {
    
    @Autowired
    private MessageSource messageSource;
    
    @Autowired
    TipoclienteServicioI ventaServicioI;
    

    @RequestMapping(value = {"/tipoclientemain"}, method = RequestMethod.GET)
    public ModelAndView inicioTipoCliente(Locale locale, Map<String, Object> model) {
        String welcome =messageSource.getMessage("welcome.message", new Object[]{"-A-N-O-N-Y-M-O-U-S-"}, locale);
        List<VentTipoCliente> lista = ventaServicioI.listarEntidad();

        model.put("ListaVenta", lista);
        model.put("message", welcome);
        model.put("startMeeting", "09:10");
        return new ModelAndView("venta/tipocliente/mainTipoCliente");
    }
      @RequestMapping(value = {"/buscavtc"}, method = RequestMethod.POST)
    public  ModelAndView buscarEntidad(Map<String,Object> model, HttpServletRequest r, @ModelAttribute("modelovtc")VentTipoCliente vtc,
        BindingResult result){
        String dato=r.getParameter("dato");
        List<VentTipoCliente> lista=ventaServicioI.listarEntidadDato(dato);
        model.put("ListaVenta", lista);
        model.put("noresults", "No matches were found.");
        model.put("accion", "Add...");
        return new ModelAndView("venta/tipocliente/mainTipoCliente");
    } 
    
     @RequestMapping(value = {"/elimvtc"}, method = RequestMethod.GET)
    public ModelAndView eliminarPersona(HttpServletRequest r) {
        int idEntidad = Integer.parseInt(r.getParameter("id"));
        ventaServicioI.eliminarEntidad(idEntidad);
        return new ModelAndView(new RedirectView("/tipoclientemain"));
    }
    
      @RequestMapping(value = "/formvtc", method = RequestMethod.GET)
    public ModelAndView irFormulario(@ModelAttribute("modelovtc") VentTipoCliente vtc,
            BindingResult result, Model model) {
//        List<GloUnidadMedida> Umedida = unidadmedidaServicioI.listarEntidad();
        model.addAttribute("urlAccion", "guardarUMP");
//        model.addAttribute("ListarUnidadMedida", Umedida);
////
//        List<GloProductos> producto = productoServicioI.listarEntidad();
//        model.addAttribute("ListaProducto", producto);
        return new ModelAndView("venta/tipocliente/formTipoCliente");
    }
    
     @RequestMapping(value = "/guardarTC", method = RequestMethod.POST)
    public ModelAndView guardarEntidad(@ModelAttribute("modelovtc")VentTipoCliente vtc, BindingResult result, Model model){        
        if(vtc.getIdTipoCliente()== null)
            ventaServicioI.guardarEntidad(vtc);
	else
            ventaServicioI.modificarEntidad(vtc);
        return new ModelAndView(new RedirectView("/tipoclientemain"));
    } 
    
          @RequestMapping(value = {"/formModivtc" }, method = RequestMethod.GET)
    public ModelAndView actualizarEntidad(HttpServletRequest r, Map<String,Object> model){
        int idEntidad=Integer.parseInt(r.getParameter("id"));       
        List<VentTipoCliente> lista = ventaServicioI.listarEntidad();
        model.put("ListaVenta", lista);
        model.put("modelovtc",ventaServicioI.buscarEntidadId(idEntidad));
        model.put("accion", "Edit...");
//        List<VentTipoCliente> Umedida = unidadmedidaServicioI.listarEntidad();
        model.put("urlAccion", "guardarTC");
//        model.put("ListarUnidadMedida", Umedida);
////
//        List<GloProductos> producto = productoServicioI.listarEntidad();
//        model.put("ListaProducto", producto);
        return new ModelAndView("venta/tipocliente/formTipoCliente");
    }
}
