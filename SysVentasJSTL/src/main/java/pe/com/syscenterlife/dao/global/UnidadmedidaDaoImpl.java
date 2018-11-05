/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.dao.global;

import java.util.List;
import org.springframework.stereotype.Repository;

import pe.com.syscenterlife.SysDataAccess;
import pe.com.syscenterlife.modelo.GloUnidadMedida;

/**
 *
 * @author quiroga
 */
@Repository
public class UnidadmedidaDaoImpl extends SysDataAccess<Integer, GloUnidadMedida> implements UnidadmedidaDaoI{
    @SuppressWarnings("unchecked")

    @Override
    public List<GloUnidadMedida> listarEntidad() {
        return getListAll(); 
    }

    @Override
    public List<GloUnidadMedida> listarEntidadDato(String dato) {
        return (List<GloUnidadMedida>)sessionFactory.getCurrentSession()
                .createQuery("SELECT um FROM GloUnidadMedida um WHERE um.nombre LIKE ?1")
                .setParameter(1,"%"+dato+"%")
                .list();    
    }

    @Override
    public GloUnidadMedida buscarEntidadId(int id) {
        return getById(id);
    }

    @Override
    public void guardarEntidad(GloUnidadMedida unidadMedida) {
        savev(unidadMedida); 
    }

    @Override
    public void eliminarEntidad(int id) {
        delete(id);
    }

    @Override
    public void modificarEntidad(GloUnidadMedida unidadMedida) {
        update(unidadMedida); 
    }
}
