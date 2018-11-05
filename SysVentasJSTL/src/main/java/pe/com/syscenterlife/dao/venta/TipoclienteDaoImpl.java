/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.dao.venta;

import java.util.List;
import org.springframework.stereotype.Repository;
import pe.com.syscenterlife.SysDataAccess;
import pe.com.syscenterlife.modelo.VentTipoCliente;

@Repository
public class TipoclienteDaoImpl extends SysDataAccess<Integer, VentTipoCliente> implements TipoclienteDaoI{
    
    @SuppressWarnings("unchecked")

    @Override
    public List<VentTipoCliente> listarEntidad() {
        return getListAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<VentTipoCliente> listarEntidadDato(String dato) {
          return (List<VentTipoCliente>)sessionFactory.getCurrentSession()
                .createQuery("SELECT p from VentTipoCliente p WHERE p.nombre LIKE ?1 ")
                .setParameter(1, "%"+dato+"%")
                .list();                
                } 
    

    @Override
    public VentTipoCliente buscarEntidadId(int id) {
        return getById(id); 
    }

    @Override
    public void guardarEntidad(VentTipoCliente tipoCliente) {
        savev(tipoCliente); 
    }

    @Override
    public void eliminarEntidad(int id) {
        delete(id); 
    }

    @Override
    public void modificarEntidad(VentTipoCliente tipoCliente) {
        update(tipoCliente); 
    }
}
