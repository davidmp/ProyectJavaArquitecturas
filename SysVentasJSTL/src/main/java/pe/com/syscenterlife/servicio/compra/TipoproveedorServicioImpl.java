/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.servicio.compra;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.syscenterlife.dao.compra.TipoproveedorDaoI;
import pe.com.syscenterlife.modelo.CompTipoProveedor;

/**
 *
 * @author davidmp
 */
@Service
@Transactional
public class TipoproveedorServicioImpl implements TipoproveedorServicioI{
    @Autowired
    public TipoproveedorDaoI daoI;    
    
    @Override
    public List<CompTipoProveedor> listarEntidad(){return  daoI.listarEntidad();}
    @Override    
    public List<CompTipoProveedor> listarEntidadDato(String dato){return daoI.listarEntidadDato(dato);}
    @Override    
    public CompTipoProveedor buscarEntidadId(int id){return daoI.buscarEntidadId(id);}
    @Override    
    public void guardarEntidad(CompTipoProveedor tipoProveedor){daoI.guardarEntidad(tipoProveedor);}
    @Override    
    public void eliminarEntidad(int id){daoI.eliminarEntidad(id);}
    @Override    
    public void modificarEntidad(CompTipoProveedor tipoProveedor){daoI.modificarEntidad(tipoProveedor);}      
}
