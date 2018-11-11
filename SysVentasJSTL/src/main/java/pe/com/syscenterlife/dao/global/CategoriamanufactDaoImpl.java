/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.dao.global;


import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Repository;
import pe.com.syscenterlife.SysDataAccess;
import pe.com.syscenterlife.modelo.GloCategoriamanufact;

/**
 *
 * @author LAB_SOFTWARE-DTI
 */
@Repository
public class CategoriamanufactDaoImpl extends SysDataAccess<Integer, GloCategoriamanufact> implements CategoriamanufactDaoI{

        @SuppressWarnings("unchecked")
    
        @Override
        public List<GloCategoriamanufact> listarEntidad(){return getListAll();}
        @Override
        public List<GloCategoriamanufact> listarEntidadDato(String dato){
        return (List<GloCategoriamanufact>)sessionFactory.getCurrentSession()
                .createQuery("SELECT px FROM GloCategoriamanufact px WHERE CONCAT(px.nombre,' ', px.estado) LIKE ?1")
                .setParameter(1, "%"+dato+"%").list();
        }
        @Override
        public GloCategoriamanufact buscarEntidadId(int id){return getById(id);}
        @Override
        public void guardarEntidad(GloCategoriamanufact categoriamanufact){savev(categoriamanufact);}
        @Override
        public void eliminarEntidad(int id){delete(id);}
        @Override
        public void modificarEntidad(GloCategoriamanufact categoriamanufact){update(categoriamanufact);}
}
