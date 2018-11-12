/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.control.system;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pe.com.syscenterlife.modelo.ViewSysAccesos;
import pe.com.syscenterlife.servicio.system.AccesoServicioI;

/**
 *
 * @author davidmp
 */
@Controller
public class AccesoControl {
   
    @Autowired
    private MessageSource messageSource;    
    @Autowired
    AccesoServicioI servicioI;
    
    Logger logger = Logger.getLogger(AccesoControl.class.getName());
    
    @RequestMapping(value = {"/mainAcceso" }, method = RequestMethod.GET)    
    public ModelAndView inicioAcceso(Locale locale, Map<String,Object> model, HttpServletRequest r){
        String welcome=messageSource.getMessage("welcome.message", new Object[]{"David Mamani"}, locale);
        r.getSession().setAttribute("idUsuario", 1);
        int idUsuario=Integer.parseInt(String.valueOf(r.getSession().getAttribute("idUsuario")));
        List<ViewSysAccesos> lista=servicioI.listarEntidadDato(idUsuario);

        model.put("ListaAcceso", lista);
        model.put("message", welcome);
        model.put("startMeeting", "09:10");

        return new ModelAndView("system/acceso/mainAcceso");
    }    
    
}
