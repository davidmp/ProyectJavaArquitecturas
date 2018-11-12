/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.dao.global;

import java.util.List;
import org.springframework.stereotype.Repository;
import pe.com.syscenterlife.SysDataAccess;
import pe.com.syscenterlife.modelo.GloPeriodo;

/**
 *
 * @author HEBERT
 */
@Repository
public class PeriodoDaoImpl extends SysDataAccess<Integer, GloPeriodo> implements PeriodoDaoI{
        @SuppressWarnings("unchecked")

        @Override
        public List<GloPeriodo> listarEntidad(){return getListAll();}
        @Override
        public List<GloPeriodo> listarEntidadDato(String dato){
        return (List<GloPeriodo>)sessionFactory.getCurrentSession()
                .createQuery("SELECT p FROM GloPeriodo p WHERE p.periodo LIKE ?1")
                .setParameter(1, "%"+dato+"%").list();
        }
        
        
        @Override
        public List<GloPeriodo> listarEntidadProcedure(String dato){
        return (List<GloPeriodo>)sessionFactory.getCurrentSession()
                .createNativeQuery("{ CALL getPeriodoByPeriodo(?1) }",GloPeriodo.class)
                .setParameter(1, dato).getResultList();
        }
        
        @Override
        public List<Object> operacionIgv (double monto){
        return (List<Object>) sessionFactory.getCurrentSession()
                .createNativeQuery("{ CALL operacionIgv(?1)}")
                .setParameter(1, monto).getResultList();
        }
        
        @Override
        public GloPeriodo buscarEntidadId(int id){return getById(id);}
        @Override
        public void guardarEntidad(GloPeriodo periodo){savev(periodo);}
        @Override
        public void eliminarEntidad(int id){delete(id);}
        @Override
        public void modificarEntidad(GloPeriodo periodo){update(periodo);}
}
