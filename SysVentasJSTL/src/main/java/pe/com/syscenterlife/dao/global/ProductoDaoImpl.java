/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.dao.global;

import java.util.List;
import org.springframework.stereotype.Repository;

import pe.com.syscenterlife.SysDataAccess;
import pe.com.syscenterlife.modelo.GloProductos;

/**
 *
 * @author quiroga
 */
@Repository
public class ProductoDaoImpl extends SysDataAccess<Integer, GloProductos> implements ProductoDaoI{
    
     @SuppressWarnings("unchecked")


    @Override
    public List<GloProductos> listarEntidad() {
        return getListAll(); 
    }

    @Override
    public List<GloProductos> listarEntidadDato(String dato) {
         return (List<GloProductos>)sessionFactory.getCurrentSession()
                .createQuery("SELECT p from GloProductos p WHERE p.nombre LIKE ?1 ")
                .setParameter(1, "%"+dato+"%")
                .list();  
    }

    @Override
    public GloProductos buscarEntidadId(int id) {
        return getById(id); 
    }

    @Override
    public void guardarEntidad(GloProductos producto) {
        savev(producto); 
    }

    @Override
    public void eliminarEntidad(int id) {
        delete(id); 
    }

    @Override
    public void modificarEntidad(GloProductos producto) {
        update(producto); 
    }
    
}
