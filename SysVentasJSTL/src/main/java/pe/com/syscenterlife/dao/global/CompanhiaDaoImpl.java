/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.dao.global;

import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.stereotype.Repository;
import pe.com.syscenterlife.SysDataAccess;
import pe.com.syscenterlife.modelo.GloCompanhia;

/**
 *
 * @author pc
 */
@Repository
public class CompanhiaDaoImpl extends SysDataAccess<Integer, GloCompanhia> implements CompanhiaDaoI{
    
    @SuppressWarnings("unchecked")
    
    @Override
    public List<GloCompanhia> listarEntidad(){return getListAll();}
    @Override
    public List<GloCompanhia> listarEntidadDato(String dato){
        return (List<GloCompanhia>)sessionFactory.getCurrentSession()
                .createQuery("SELECT p from GloCompanhia p WHERE p.nombre LIKE ?1 ")
                .setParameter(1, "%"+dato+"%")
                .list();
    }
    @Override
    public GloCompanhia buscarEntidadId(int id){return getById(id);}
    @Override
    public void guardarEntidad(GloCompanhia companhia){savev(companhia);}
    @Override
    public void eliminarEntidad(int id){delete(id);}
    @Override
    public void modificarEntidad(GloCompanhia companhia){update(companhia);}
}
