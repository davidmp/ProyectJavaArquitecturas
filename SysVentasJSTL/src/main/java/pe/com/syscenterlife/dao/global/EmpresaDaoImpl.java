/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.dao.global;

import java.util.List;
import org.springframework.stereotype.Repository;
import pe.com.syscenterlife.SysDataAccess;
import pe.com.syscenterlife.modelo.GloEmpresa;

/**
 *
 * @author pc
 */

@Repository
public class EmpresaDaoImpl extends SysDataAccess<Integer, GloEmpresa> implements EmpresaDaoI{
 
    @SuppressWarnings("unchecked")

@Override
    public List<GloEmpresa> listarEntidad(){return getListAll();}
    @Override
    public List<GloEmpresa> listarEntidadDato(String dato){
        return (List<GloEmpresa>)sessionFactory.getCurrentSession()
                .createQuery("SELECT p from GloEmpresa p WHERE p.razonsocial LIKE ?1 ")
                .setParameter(1, "%"+dato+"%")
                .list();
    }
    @Override
    public GloEmpresa buscarEntidadId(int id){return getById(id);}
    @Override
    public void guardarEntidad(GloEmpresa empresa){savev(empresa);}
    @Override
    public void eliminarEntidad(int id){delete(id);}
    @Override
    public void modificarEntidad(GloEmpresa empresa){update(empresa);}
}
