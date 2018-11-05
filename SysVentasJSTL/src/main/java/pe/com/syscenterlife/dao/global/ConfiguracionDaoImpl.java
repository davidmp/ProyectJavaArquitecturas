/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.dao.global;

import java.util.List;
import org.springframework.stereotype.Repository;
import pe.com.syscenterlife.SysDataAccess;

import pe.com.syscenterlife.modelo.GloConfiguracion;

/**
 *
 * @author Juan Jose
 */
@Repository
public class ConfiguracionDaoImpl extends SysDataAccess<Integer, GloConfiguracion> implements ConfiguracionDaoI{
    
   @SuppressWarnings("unchecked")
    
    @Override
    public List<GloConfiguracion> listarEntidad(){return getListAll();}
    @Override
    public List<GloConfiguracion> listarEntidadDato(String dato){
            return (List<GloConfiguracion>)sessionFactory.getCurrentSession()
                .createQuery("SELECT p from GloConfiguracion p WHERE  p.igvPorcent LIKE ?1 ")
                .setParameter(1, "%"+dato+"%")
                .list(); 
    }
    @Override
    public GloConfiguracion buscarEntidadId(int id){return getById(id);}
    @Override
    public void guardarEntidad(GloConfiguracion configuracion){savev(configuracion);}
    @Override
    public void eliminarEntidad(int id){delete(id);}
    @Override
    public void modificarEntidad(GloConfiguracion configuracion){update(configuracion);}

























//    @Override
//    public List<GloConfiguracion> listarEntidad(){return getListAll();}
//    @Override
//    public List<GloConfiguracion> listarEntidadDato(String dato){return null};}
//    @Override
//    public GloConfiguracion buscarEntidadId(int id){return getById(id);}
//    @Override
//    public void guardarEntidad(GloConfiguracion configuracion){savev(configuracion);}
//    @Override
//    public void eliminarEntidad(int id){delete(id);}
//    @Override
//    public void modificarEntidad(GloConfiguracion configuracion){update(configuracion);}
    
}
