/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.dao.global;

import java.util.List;
import pe.com.syscenterlife.SysDataAccess;
import org.springframework.stereotype.Repository;
import pe.com.syscenterlife.modelo.GloManufactura;

/**
 *
 * @author edwil
 */
@Repository
public class ManufacturaDaoImpl extends SysDataAccess<Integer, GloManufactura> implements ManufacturaDaoI{

    @SuppressWarnings("unchecked")
    
    @Override
    public List<GloManufactura> listarEntidad(){return getListAll();}
    @Override
    public List<GloManufactura> listarEntidadDato(String dato){
            return (List<GloManufactura>)sessionFactory.getCurrentSession()
                .createQuery("SELECT p from GloManufactura p WHERE p.nombre LIKE ?1 ")
                .setParameter(1, "%"+dato+"%")
                .list(); 
    }
    @Override
    public GloManufactura buscarEntidadId(int id){return getById(id);}
    @Override
    public void guardarEntidad(GloManufactura manufactura){savev(manufactura);}
    @Override
    public void eliminarEntidad(int id){delete(id);}
    @Override
    public void modificarEntidad(GloManufactura manufactura){update(manufactura);}
    
}
