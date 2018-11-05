/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.servicio.venta;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.syscenterlife.dao.venta.TipoclienteDaoI;
import pe.com.syscenterlife.modelo.VentTipoCliente;

@Service
@Transactional
public class TipoclienteServicioImpl implements TipoclienteServicioI{
    
    @Autowired
    public TipoclienteDaoI daoI;

    @Override
    public List<VentTipoCliente> listarEntidad() {
        return daoI.listarEntidad(); 
    }

    @Override
    public List<VentTipoCliente> listarEntidadDato(String dato) {
        return daoI.listarEntidadDato(dato); 
    }

    @Override
    public VentTipoCliente buscarEntidadId(int id) {
        return daoI.buscarEntidadId(id); 
    }

    @Override
    public void guardarEntidad(VentTipoCliente tipoCliente) {
        daoI.guardarEntidad(tipoCliente); 
    }

    @Override
    public void eliminarEntidad(int id) {
        daoI.eliminarEntidad(id); 
    }

    @Override
    public void modificarEntidad(VentTipoCliente tipoCliente) {
        daoI.modificarEntidad(tipoCliente); 
    }
}
