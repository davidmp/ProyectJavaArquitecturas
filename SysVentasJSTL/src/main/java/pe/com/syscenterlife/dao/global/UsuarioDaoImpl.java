/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.dao.global;

import java.util.List;
import org.springframework.stereotype.Repository;
import pe.com.syscenterlife.SysDataAccess;
import pe.com.syscenterlife.modelo.GloPersonas;
import pe.com.syscenterlife.modelo.GloUsuario;
import pe.com.syscenterlife.modelo.IdGenerator;

/**
 *
 * @author davidmp
 */
@Repository
public class UsuarioDaoImpl extends SysDataAccess<Integer, GloUsuario> implements UsuarioDaoI{
    
    @SuppressWarnings("unchecked")
    
    @Override
    public List<GloUsuario> listarEntidad(){return getListAll();}
    @Override
    public List<GloUsuario> listarEntidadDato(String dato){
        return (List<GloUsuario>)sessionFactory.getCurrentSession()
                .createQuery("SELECT p from GloUsuario p WHERE p.idPersona.usuario LIKE ?1 ")
                .setParameter(1, "%"+dato+"%")
                .list();     
    }
    @Override
    public GloUsuario buscarEntidadId(int id){return getById(id);}
    
    @Override
    public GloUsuario validarLogin(GloPersonas user){
    GloUsuario resultado=null;   
    String usuario=user.getUsuario(); 
    String pasword=user.getClave();
    try {           
       resultado= (GloUsuario) sessionFactory.getCurrentSession()
                                .createQuery("SELECT p from GloUsuario p WHERE p.idPersona.usuario=?1 and p.idPersona.clave=?2")
                                .setParameter(1, usuario)
                                .setParameter(2, pasword).uniqueResult();                                 
        }catch (Exception e) { logger.info("Mensage de Error en validarUsuario() "+e.getMessage());   }
        //finally{ sessionFactory.close(); }            
        return resultado;    
    }
    @Override
    public void guardarEntidad(GloUsuario usuario){savev(usuario);}
    @Override
    public void eliminarEntidad(int id){delete(id);}
    @Override
    public void modificarEntidad(GloUsuario usuario){update(usuario);}
    @Override
    public IdGenerator idUsuarioGenerator(){
        IdGenerator to=null;     
        try {     
        to= (IdGenerator) sessionFactory.getCurrentSession()
                .createNativeQuery(" SELECT ((CASE WHEN MAX(a.idUsuario) IS NULL THEN 0 ELSE MAX(a.idUsuario) END)+1) AS id FROM glo_usuario a ", IdGenerator.class)                
               .uniqueResult();           
        }catch (Exception e) { logger.info("Mensage de Error en idUsuarioGenerator() "+e.getMessage());   }              
        return to;      
    }
    
    @Override
    public List<GloUsuario> validarUsuario(GloPersonas user) {
    List<GloUsuario> resultado=null;
    try {           
       resultado= (List<GloUsuario>) sessionFactory.getCurrentSession().createQuery(" SELECT p from GloUsuario p WHERE p.idPersona.usuario=?1 ")
                                             .setParameter(1, user.getUsuario())
                                             .list();                      
        }catch (Exception e) { logger.info("Mensage de Error en validarTrabajador() "+e.getMessage());   }
        //finally{ sessionFactory.close(); }            
        return resultado;
    }    
}
