/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.dao.global;

import java.util.List;
import org.springframework.stereotype.Repository;
import pe.com.syscenterlife.SysDataAccess;
import pe.com.syscenterlife.modelo.GloAlmacen;

/**
 *
 * @author HEBERT
 */
@Repository
public class AlmacenDaoImpl extends SysDataAccess<Integer, GloAlmacen> implements AlmacenDaoI {
    
        @SuppressWarnings("unchecked")
    
        @Override
        public List<GloAlmacen> listarEntidad(){return getListAll();}
        @Override
        public List<GloAlmacen> listarEntidadDato(String dato){
        return (List<GloAlmacen>)sessionFactory.getCurrentSession()
                .createQuery("SELECT p FROM GloAlmacen p WHERE p.nombreAlmacen LIKE ?1")
                .setParameter(1, "%"+dato+"%").list();
        }
        
        @Override
        public int operacionProcedure(int id){
               return sessionFactory.getCurrentSession()
                .createNativeQuery("{ CALL getAlmacenDelete(?1) }")
                .setParameter(1, id)                                    
                .executeUpdate();
        }      
        
        @Override
        public GloAlmacen buscarEntidadId(int id){return getById(id);}
        @Override
        public void guardarEntidad(GloAlmacen almacen){savev(almacen);}
        @Override
        public void eliminarEntidad(int id){delete(id);}
        @Override
        public void modificarEntidad(GloAlmacen almacen){update(almacen);}
}
