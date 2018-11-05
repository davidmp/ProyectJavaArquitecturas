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
import pe.com.syscenterlife.modelo.GloCategoriaProducto;

import pe.com.syscenterlife.servicio.global.CategoriaProductoServicioI;



/**
 *
 * @author Student
 */
@Controller
public class CategoriaProductoControl {
    @Autowired
    private MessageSource messageSource;
    
    @Autowired
    CategoriaProductoServicioI categoriaServicioI;

    
    Logger logger = Logger.getLogger(PersonaControl.class.getName());
    
    @RequestMapping(value = {"/catProMain" }, method = RequestMethod.GET)    
    public ModelAndView inicioCat(Locale locale, Map<String,Object> model){

        List<GloCategoriaProducto> lista=categoriaServicioI.listarEntidad();

        model.put("ListaCategoria", lista);

        return new ModelAndView("global/categoriaprodu/mainCategoria");
    }
    
    @RequestMapping(value = {"/elimCatPro" }, method = RequestMethod.GET)
    public ModelAndView eliminarPersona(HttpServletRequest r){
        int idEntidad=Integer.parseInt(r.getParameter("id"));
        categoriaServicioI.eliminarEntidad(idEntidad);
    return new ModelAndView(new RedirectView("/catProMain"));
    }



  
    @RequestMapping(value = {"/buscarCatPro"}, method = RequestMethod.POST)
    public  ModelAndView buscarEntidad(Locale locale, Map<String,Object> model, HttpServletRequest r){
        String welcome=messageSource.getMessage("welcome.message", new Object[]{"David Mamani"}, locale);
        String dato=r.getParameter("dato");
        List<GloCategoriaProducto> lista=categoriaServicioI.listarEntidadDato(dato);
        model.put("listaCategoria", lista);
        model.put("message", welcome);
        model.put("startMeeting", "09:10");    
    return new ModelAndView("global/categoriaprodu/mainCategoria");
    }

    @RequestMapping(value = "/formCategoriaProd", method = RequestMethod.GET)
    public ModelAndView irFormulario(@ModelAttribute("modeloEntidad")GloCategoriaProducto persona,
                BindingResult result, Model model){
            Map<String,String> genero = new LinkedHashMap<String,String>();
            genero.put("F", "Femenino");
            genero.put("M", "Masculino");

            Map<String,String> idioma = new LinkedHashMap<String,String>();
            idioma.put("en", "Ingles");
            idioma.put("es", "Español");

            model.addAttribute("urlAccion", "guardarCategoriaProd"); 
            model.addAttribute("ListGenero", genero); 
            model.addAttribute("ListIdioma", idioma); 
        return new ModelAndView("global/categoriaprodu/formCategoria");
    }

    @RequestMapping(value = "/guardarCategoriaProd", method = RequestMethod.POST)
    public ModelAndView guardarEntidad(@ModelAttribute("modeloEntidad")GloCategoriaProducto categoria,
            BindingResult result, HttpServletRequest r){
            logger.info("Error Fecha: "+categoria.getNombre());
            try {
            categoriaServicioI.guardarEntidad(categoria);
            return new ModelAndView(new RedirectView("/catProMain"));
            } catch (Exception e) { 
            logger.info("Error Guardar: "+e.getMessage());    
            return new ModelAndView(new RedirectView("/formCategoriaProd"));
            }    
    }

    @RequestMapping(value = "/formModifCategoriaProd", method = RequestMethod.GET)
    public ModelAndView irModificarPersona(HttpServletRequest r ){
       int id=Integer.parseInt(r.getParameter("id"));
           GloCategoriaProducto entidad=null;
           entidad=categoriaServicioI.buscarEntidadId(id);
        return new ModelAndView("global/categoriaprodu/formCategoria","modeloEntidad",entidad);
    }

    @RequestMapping(value = "/formModif2CategoriaProd", method = RequestMethod.GET)
    public String irModificar2Persona(HttpServletRequest r, Model model ){
       int id=Integer.parseInt(r.getParameter("id"));
           GloCategoriaProducto categoria=null;
           categoria=categoriaServicioI.buscarEntidadId(id);
           logger.info("Error Fecha Real "+categoria.getEstado());

            Map<String,String> genero = new LinkedHashMap<String,String>();
            genero.put("F", "Femenino");
            genero.put("M", "Masculino");

            Map<String,String> idioma = new LinkedHashMap<String,String>();
            idioma.put("en", "Ingles");
            idioma.put("es", "Español");       
            model.addAttribute("modeloPersona", categoria);  
            model.addAttribute("ListGenero", genero); 
            model.addAttribute("ListIdioma", idioma);

            model.addAttribute("urlAccion", "actualizarCategoriaProd");             
        return "global/categoriaprodu/formPersona";
    }

    @RequestMapping(value = "actualizarCategoriaProd", method = RequestMethod.POST)
    public ModelAndView actualizarPersona(@ModelAttribute("modeloEntidad") GloCategoriaProducto categoria,
                                          BindingResult result, HttpServletRequest r ){
        try {
            categoriaServicioI.modificarEntidad(categoria);
            return new ModelAndView(new RedirectView(r.getContextPath()+"/catProMain"));
        } catch (Exception e) {
            logger.info("Error al modificar: "+e.getMessage());
            return new ModelAndView(new RedirectView(r.getContextPath()+"/formModif2CategoriaProd?id="+categoria.getIdCategoria()));
        }

    }
}