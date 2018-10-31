/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.dao.global;

import java.util.List;
import org.springframework.stereotype.Repository;
import pe.com.syscenterlife.SysDataAccess;
import pe.com.syscenterlife.modelo.GloCodigopostal;

/**
 *
 * @author davidmp
 */
@Repository
public class CodigopostalDaoImpl extends SysDataAccess<Integer, GloCodigopostal> implements CodigopostalDaoI{
    
    @SuppressWarnings("unchecked")
    
    @Override
    public List<GloCodigopostal> listarEntidad(){return getListAll();}
    @Override
    public List<GloCodigopostal> listarEntidadDato(String dato){
            return (List<GloCodigopostal>)sessionFactory.getCurrentSession()
                .createQuery("SELECT p from GloCodigopostal p WHERE p.ubigeo LIKE ?1 ")
                .setParameter(1, "%"+dato+"%")
                .list(); 
    }
    @Override
    public GloCodigopostal buscarEntidadId(int id){return getById(id);}
    @Override
    public void guardarEntidad(GloCodigopostal codigopostal){savev(codigopostal);}
    @Override
    public void eliminarEntidad(int id){delete(id);}
    @Override
    public void modificarEntidad(GloCodigopostal codigopostal){update(codigopostal);}
}
