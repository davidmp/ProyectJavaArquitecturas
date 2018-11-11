/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.dao.global;

import java.util.List;
import org.springframework.stereotype.Repository;
import pe.com.syscenterlife.SysDataAccess;
import pe.com.syscenterlife.modelo.GloAperturaPeriodo;

/**
 *
 * @author HEBERT
 */
@Repository
public class AperturaPeriodoDaoImpl extends SysDataAccess<Integer, GloAperturaPeriodo> implements AperturaPeriodoDaoI{
    
    @SuppressWarnings("unchecked")
    
    @Override
    public List<GloAperturaPeriodo> listarEntidad(){ return getListAll();}    
        
    
    @Override
    public List<GloAperturaPeriodo> listarEntidadDato(String dato){
        return (List<GloAperturaPeriodo>)sessionFactory.getCurrentSession()
                .createQuery("SELECT p from GloAperturaPeriodo p WHERE p.ip LIKE ?1 ")
                .setParameter(1, "%"+dato+"%")
                .list();                
                }
    
    @Override
    public GloAperturaPeriodo buscarEntidadId(int id){ return getById(id);}
    
    @Override
    public void guardarEntidad(GloAperturaPeriodo apper){savev(apper);}
    @Override
    public void eliminarEntidad(int id){delete(id);}
    @Override
    public void modificarEntidad(GloAperturaPeriodo apper){update(apper);}
}
