/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.control.global;

import java.util.Iterator;
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
import pe.com.syscenterlife.modelo.GloPeriodo;
import pe.com.syscenterlife.servicio.global.PeriodoServicioI;

/**
 *
 * @author davidmp
 */
@Controller
public class PeriodoControl {
  
    @Autowired
    private MessageSource messageSource;   
    
    @Autowired
    PeriodoServicioI periodoServicioI;    
    
    Logger logger = Logger.getLogger(PeriodoControl.class.getName());    
    
@RequestMapping(value = {"/periodoMain" }, method = RequestMethod.GET)    
public ModelAndView inicioPeriodo(Locale locale, Map<String,Object> model){
    String welcome=messageSource.getMessage("welcome.message", new Object[]{"David Mamani"}, locale);
    List<GloPeriodo> lista=periodoServicioI.listarEntidad();

    model.put("ListaPeriodo", lista);
    model.put("message", welcome);
    model.put("startMeeting", "09:10");
    
    return new ModelAndView("global/periodo/mainPeriodo");
}   

@RequestMapping(value = {"/buscarPeriodo"}, method = RequestMethod.POST)
public  ModelAndView buscarEntidad(Locale locale, Map<String,Object> model, HttpServletRequest r){
    String welcome=messageSource.getMessage("welcome.message", new Object[]{"David Mamani"}, locale);
    String dato=r.getParameter("dato");
    List<GloPeriodo> lista=periodoServicioI.listarEntidadProcedure(dato);
    
    double monto=Double.parseDouble(r.getParameter("monto"));
    
    List<Object> listOper=periodoServicioI.operacionIgv(monto);
    
    Iterator it=listOper.iterator();
    while (it.hasNext()) {
        Object[] next = (Object[])it.next();
        logger.info("IGV : " +next[0]);
        logger.info("Importe : " +next[1]);        
        welcome+="IGV: "+next[0]+ "------Importe: "+next[1];
    }    
    model.put("ListaPeriodo", lista);
    model.put("message", welcome);
    model.put("startMeeting", "09:10");    
    return new ModelAndView("global/periodo/mainPeriodo");
}
}
