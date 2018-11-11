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
import pe.com.syscenterlife.modelo.GloAlmacen;
import pe.com.syscenterlife.modelo.GloSucursal;
import pe.com.syscenterlife.servicio.global.AlmacenServicioI;
import pe.com.syscenterlife.servicio.global.SucursalServicioI;

/**
 *
 * @author Student
 */
@Controller
public class AlmacenControl {
     
    @Autowired
    private MessageSource messageSource;
    @Autowired
    AlmacenServicioI almacenServicioI;
    @Autowired
    SucursalServicioI sucursalServicioI;

    Logger logger = Logger.getLogger(AlmacenControl.class.getName());
    
    @RequestMapping(value = {"/almMain" }, method = RequestMethod.GET)    
    public ModelAndView inicioAlmacen(Locale locale, Map<String,Object> model){
        String welcome=messageSource.getMessage("welcome.message", new Object[]{"David Mamani"}, locale);
        List<GloAlmacen> lista=almacenServicioI.listarEntidad();

        model.put("ListaAlmacen", lista);
        model.put("message", welcome);
        model.put("startMeeting", "09:10");        
        return new ModelAndView("global/almacen/mainAlmacen");
    } 
    
    @RequestMapping(value = {"/buscarAlm"}, method = RequestMethod.POST)
    public  ModelAndView buscarEntidadd(Locale locale, Map<String,Object> model, HttpServletRequest r){
        String welcome=messageSource.getMessage("welcome.message", new Object[]{"David Mamani"}, locale);
        String dato=r.getParameter("dato");
        List<GloAlmacen> lista=almacenServicioI.listarEntidadDato(dato);
        model.put("ListaAlmacen", lista);
        model.put("message", welcome);
        model.put("startMeeting", "09:10");    
    return new ModelAndView("global/almacen/mainAlmacen");
    } 
    
    @RequestMapping(value = {"/elimAlm" }, method = RequestMethod.GET)
    public ModelAndView eliminarAlmacen(HttpServletRequest r){
        int idEntidad=Integer.parseInt(r.getParameter("id"));
       int dato= almacenServicioI.operacionProcedure(idEntidad);
       
      logger.info("Mensaje Mostrado Procedure: "+dato);
        //almacenServicioI.eliminarEntidad(idEntidad);
    return new ModelAndView(new RedirectView("/almMain"));
    }
    
//    @RequestMapping(value = "/formAlmacen", method = RequestMethod.GET)
//public String irModificarAlmacen(HttpServletRequest r, Model model ){
//        int id=Integer.parseInt(r.getParameter("id"));
//        GloAlmacen almacen=null;
//        almacen=almacenServicioI.buscarEntidadId(id);
//        
//        return "inventario/almacen/formAlmacen";
//}

@RequestMapping(value = "/formAlmacen", method = RequestMethod.GET)
public ModelAndView irFormulario(@ModelAttribute("modeloAlmacen")GloAlmacen almacen,
        BindingResult result, Model model){
        List<GloSucursal> sucursal=sucursalServicioI.listarEntidad();
        model.addAttribute("ListaSucursal", sucursal);
        model.addAttribute("urlAccion", "guardarAlmacen"); 
        
    return new ModelAndView("global/almacen/formAlmacen");
}

@RequestMapping(value = "/guardarAlmacen", method = RequestMethod.POST)
public ModelAndView guardarEntidadd(@ModelAttribute("modeloAlmacen")GloAlmacen almacen,
        BindingResult result, HttpServletRequest r){

        try {
        almacenServicioI.guardarEntidad(almacen);
        return new ModelAndView(new RedirectView("/almMain"));
        } catch (Exception e) {
        logger.info("Error Guardar: "+e.getMessage());
        return new ModelAndView(new RedirectView("/formAlmacen"));
        }
}

@RequestMapping(value = "/formModif2Almacen", method = RequestMethod.GET)
public String irModificar2Almacen(HttpServletRequest r, Model model ){
   int id=Integer.parseInt(r.getParameter("id"));
       GloAlmacen almacen=null;
       almacen=almacenServicioI.buscarEntidadId(id);
       List<GloSucursal> sucursal=sucursalServicioI.listarEntidad();
        model.addAttribute("modeloAlmacen", almacen);  
        model.addAttribute("ListaSucursal", sucursal);
        model.addAttribute("urlAccion", "actualizarAlmacen");             
    return "global/almacen/formAlmacen";
}


@RequestMapping(value = "actualizarAlmacen", method = RequestMethod.POST)
public ModelAndView actualizarAlmacen(@ModelAttribute("modeloAlmacen") GloAlmacen entidad,
                                      BindingResult result, HttpServletRequest r ){
        try {
        almacenServicioI.modificarEntidad(entidad);
        return new ModelAndView(new RedirectView(r.getContextPath()+"/almMain"));
    } catch (Exception e) {
        logger.info("Error al modificar: "+e.getMessage());
        return new ModelAndView(new RedirectView(r.getContextPath()+"/formModif2Almacen?id="+entidad.getIdAlmacen()));
    }
    
}

}
