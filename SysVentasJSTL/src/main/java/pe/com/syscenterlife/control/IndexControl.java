/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pe.com.syscenterlife.modelo.GloPersonas;
import pe.com.syscenterlife.modelo.GloUsuario;

import pe.com.syscenterlife.servicio.global.UsuarioServicioI;
import pe.com.syscenterlife.utils.STRCrypto;

/**
 *
 * @author davidmp
 */
@Controller
public class IndexControl {
    @Autowired
    private MessageSource messageSource;
    @Autowired
    UsuarioServicioI usuarioServicioI;

   @RequestMapping(value = "/locate", method = RequestMethod.GET)
    public String getLocatePage(){
    return "my-locale";
    }
    
    @RequestMapping(value = {"/" }, method = RequestMethod.GET)    
    public ModelAndView inicioLoginForm(Locale locale, Map<String,Object> model){
        return new ModelAndView("index");
    }
    @RequestMapping(value = {"/validatex" }, method = RequestMethod.GET)    
    public ModelAndView inicioLoginValidate(Locale locale, Map<String,Object> model){
        return new ModelAndView("global/home");
        
    }
    
@RequestMapping(value = "/validate", method = RequestMethod.POST)
        public ModelAndView loginRequest(HttpServletRequest request, HttpServletResponse response) 
                throws Exception {
        Map model = new HashMap();
        String result="";
        GloPersonas personas=new GloPersonas();
        STRCrypto crypt=new STRCrypto();
        personas.setUsuario(request.getParameter("username"));
        personas.setClave(crypt.encrypt(request.getParameter("password")));
        
        GloUsuario list= usuarioServicioI.validarLogin(personas);
               
               if(list!=null){                                            
                if(list.getEstado().equals("1")){
                int l = Integer.parseInt(list.getIdPerfil().getCodigo());
                request.getSession().setAttribute("Username", request.getParameter("username"));
                request.getSession().setAttribute("UserId", list.getIdUsuario());
                request.getSession().setAttribute("NivelFsx", list.getIdPerfil().getCodigo());
                    if(l<=5) {
                            request.getSession().setAttribute("Session2", request.getSession().getId()); 
                            ArrayList list_s= new ArrayList();
                            for (int i = l; i<=5; i++){
                                    list_s.add(""+i);
                            }						
                            //1 Super Administrador
                            //2 Administrador
                            //3 Promotor Ventas
                            //4 Apoyo Ventas
                            //5 Auditor						
                      request.getSession().setAttribute("ListAccesses",list_s);
                      }
                    result="|5|Exito|validatex|";                
                }else{
                if(!list.getEstado().equals("1") && list.getIdPerfil().getCodigo().equals("1")){
                        int l = Integer.parseInt(list.getIdPerfil().getCodigo());
                        request.getSession().setAttribute("Username", request.getParameter("username"));
                        request.getSession().setAttribute("UserId", list.getIdUsuario());
                        request.getSession().setAttribute("NivelFsx", list.getIdPerfil().getCodigo());
                            if(l<=5) {
                                    request.getSession().setAttribute("Session2", request.getSession().getId()); 
                                    ArrayList list_s= new ArrayList();
                                    for (int i = l; i<=5; i++){
                                            list_s.add(""+i);
                                    }						
                                    //1 Super Administrador
                                    //2 Administrador
                                    //3 Promotor Ventas
                                    //4 Apoyo Ventas
                                    //5 Auditor						
                              request.getSession().setAttribute("ListAccesses",list_s);
                              }
                            result="|5|Exito|validatex|";                
                }else{
                           result="2->Usted. Esta desactivado y No es Super Administrador";
                           request.getSession().setAttribute("Session2",null);
                           throw new Exception("Alert "+request.getParameter("username")+"!, Your PIN is invalidate");                
                    }               
                }               
               }else{
               List listU= usuarioServicioI.validarUsuario(personas); 
               Iterator iteratorU = listU.iterator();
                if(iteratorU.hasNext()){ result="|0|Error de clave...!";}
                else{result="|1|Personal no Registrado o no es Trabajador";}               
               }
        model.put("rsTrabajador", result);        
        return new ModelAndView("validaxion",model);
        }    
    
    @RequestMapping(value = {"/idiom" }, method = RequestMethod.GET)    
    public ModelAndView inicioIdioma(Locale locale, Map<String,Object> model){
        return new ModelAndView("global/home");
    }
    
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView loginExit(){      
    return new ModelAndView("detroyxexion");
    }    
}
