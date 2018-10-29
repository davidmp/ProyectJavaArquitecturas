/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.dao.compra;

import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Repository;
import pe.com.syscenterlife.SysDataAccess;
import pe.com.syscenterlife.modelo.CompProveedores;

/**
 *
 * @author LAB_SOFTWARE-DTI
 */
@Repository
public class ProveedorDaoImpl extends SysDataAccess<Integer, CompProveedores> implements ProveedorDaoI{

        @SuppressWarnings("unchecked")
    
        @Override
        public List<CompProveedores> listarEntidad(){return getListAll();}
        @Override
        public List<CompProveedores> listarEntidadDato(String dato){
        return (List<CompProveedores>)sessionFactory.getCurrentSession()
                .createQuery("SELECT px FROM CompProveedores px WHERE CONCAT(px.ruc,' ', px.razonsocial) LIKE ?1")
                .setParameter(1, "%"+dato+"%").list();
        }
        @Override
        public CompProveedores buscarEntidadId(int id){return getById(id);}
        @Override
        public void guardarEntidad(CompProveedores proveedores){savev(proveedores);}
        @Override
        public void eliminarEntidad(int id){delete(id);}
        @Override
        public void modificarEntidad(CompProveedores proveedores){update(proveedores);}
}
