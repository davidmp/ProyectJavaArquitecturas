/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.dao.global;

import java.util.List;
import org.springframework.stereotype.Repository;

import pe.com.syscenterlife.SysDataAccess;
import pe.com.syscenterlife.modelo.GloUnidadmedProducto;

/**
 *
 * @author quiroga
 */
@Repository
public class UmedidaproductoDaoImpl extends SysDataAccess<Integer, GloUnidadmedProducto> implements UmedidaproductoDaoI{
    
    @SuppressWarnings("unchecked")

    @Override
    public List<GloUnidadmedProducto> listarEntidad() {
        return getListAll(); 
    }

    @Override
    public List<GloUnidadmedProducto> listarEntidadDato(String dato) {
        return (List<GloUnidadmedProducto>)sessionFactory.getCurrentSession()
                .createQuery("SELECT mp FROM GloUnidadmedProducto mp WHERE mp.idProducto.nombre LIKE ?1")
                .setParameter(1,"%"+dato+"%")
                .list();   
    }

    @Override
    public GloUnidadmedProducto buscarEntidadId(int id) {
        return getById(id); 
    }

    @Override
    public void guardarEntidad(GloUnidadmedProducto unidadmedProducto) {
        savev(unidadmedProducto); 
    }

    @Override
    public void eliminarEntidad(int id) {
        delete(id); 
    }

    @Override
    public void modificarEntidad(GloUnidadmedProducto unidadmedProducto) {
        update(unidadmedProducto); 
    }

    
}
