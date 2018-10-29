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

/**
 *
 * @author LAB_SOFTWARE-DTI
 */
@Repository
public class PersonaDaoImpl extends SysDataAccess<Integer, GloPersonas> implements PersonaDaoI{
    
    @SuppressWarnings("unchecked")
    
    @Override
    public List<GloPersonas> listarEntidad(){ return getListAll();}    
        
    
    @Override
    public List<GloPersonas> listarEntidadDato(String dato){
        return (List<GloPersonas>)sessionFactory.getCurrentSession()
                .createQuery("SELECT p from GloPersonas p WHERE p.nombre LIKE ?1 ")
                .setParameter(1, "%"+dato+"%")
                .list();                
                }
    
    @Override
    public GloPersonas buscarEntidadId(int id){ return getById(id);}
    
    @Override
    public void guardarEntidad(GloPersonas persona){savev(persona);}
    @Override
    public void eliminarEntidad(int id){delete(id);}
    @Override
    public void modificarEntidad(GloPersonas persona){update(persona);}

}
