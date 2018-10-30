/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.control.compra;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import pe.com.syscenterlife.modelo.CompProveedores;

import pe.com.syscenterlife.servicio.compra.ProveedorServicioI;


/**
 *
 * @author LAB_SOFTWARE-DTI
 */
@Controller
public class ProveedorControl {
    
    @Autowired
    private MessageSource messageSource;
    @Autowired
    ProveedorServicioI proveedorServicioI;

    @RequestMapping(value = {"/provMain" }, method = RequestMethod.GET)    
    public ModelAndView inicioProveedor(Locale locale, Map<String,Object> model){
        String welcome=messageSource.getMessage("welcome.message", new Object[]{"David Mamani"}, locale);
        List<CompProveedores> lista=proveedorServicioI.listarEntidad();

        model.put("ListaProveedor", lista);
        model.put("message", welcome);
        model.put("startMeeting", "09:10");        
        return new ModelAndView("compra/proveedor/mainProveedor");
    } 
    
    @RequestMapping(value = {"/buscarProv"}, method = RequestMethod.POST)
    public  ModelAndView buscarEntidad(Locale locale, Map<String,Object> model, HttpServletRequest r){
        String welcome=messageSource.getMessage("welcome.message", new Object[]{"David Mamani"}, locale);
        String dato=r.getParameter("dato");
        List<CompProveedores> lista=proveedorServicioI.listarEntidadDato(dato);
        model.put("ListaProveedor", lista);
        model.put("message", welcome);
        model.put("startMeeting", "09:10");    
    return new ModelAndView("compra/proveedor/mainProveedor");
    } 
    
    @RequestMapping(value = {"/elimProv" }, method = RequestMethod.GET)
    public ModelAndView eliminarPersona(HttpServletRequest r){
        int idEntidad=Integer.parseInt(r.getParameter("id"));
        proveedorServicioI.eliminarEntidad(idEntidad);
    return new ModelAndView(new RedirectView("/provMain"));
    }    
}
