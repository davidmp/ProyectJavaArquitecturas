/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.control.global;

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
import pe.com.syscenterlife.modelo.GloSucursal;

import pe.com.syscenterlife.servicio.global.SucursalServicioI;
/**
 *
 * @author pc
 */
@Controller
public class SucursalControl {
    @Autowired
    private MessageSource messageSource;
    @Autowired
    SucursalServicioI sucursalServicioI;

    @RequestMapping(value = {"/sucMain" }, method = RequestMethod.GET)    
    public ModelAndView inicioSucursal(Locale locale, Map<String,Object> model){
        String welcome=messageSource.getMessage("welcome.message", new Object[]{"Pandely Ali"}, locale);
        List<GloSucursal> lista=sucursalServicioI.listarEntidad();

        model.put("ListaSucursal", lista);
        model.put("message", welcome);
        model.put("startMeeting", "09:10");

        return new ModelAndView("global/sucursal/mainSucursal");
    } 
    
    @RequestMapping(value = {"/buscarSuc"}, method = RequestMethod.POST)
    public  ModelAndView buscarEntidad(Locale locale, Map<String,Object> model, HttpServletRequest r){
        String welcome=messageSource.getMessage("welcome.message", new Object[]{"Pandely Ali"}, locale);
        String dato=r.getParameter("dato");
        List<GloSucursal> lista=sucursalServicioI.listarEntidadDato(dato);
        model.put("ListaSucursal", lista);
        model.put("message", welcome);
        model.put("startMeeting", "09:10");    
    return new ModelAndView("global/sucursal/mainSucursal");
    } 
    
    @RequestMapping(value = {"/elimSuc" }, method = RequestMethod.GET)
    public ModelAndView eliminarPersona(HttpServletRequest r){
        int idEntidad=Integer.parseInt(r.getParameter("id"));
        sucursalServicioI.eliminarEntidad(idEntidad);
    return new ModelAndView(new RedirectView("/sucMain"));
    }
}
