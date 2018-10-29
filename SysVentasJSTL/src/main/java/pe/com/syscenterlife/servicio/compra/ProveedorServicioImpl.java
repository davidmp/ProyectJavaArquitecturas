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
import pe.com.syscenterlife.dao.compra.ProveedorDaoI;
import pe.com.syscenterlife.modelo.CompProveedores;

/**
 *
 * @author LAB_SOFTWARE-DTI
 */
@Service
@Transactional
public class ProveedorServicioImpl implements ProveedorServicioI{

    @Autowired
    public ProveedorDaoI daoI;    
    @Override
    public List<CompProveedores> listarEntidad(){return daoI.listarEntidad();}
    @Override
    public List<CompProveedores> listarEntidadDato(String dato){return daoI.listarEntidadDato(dato);}
    @Override
    public CompProveedores buscarEntidadId(int id){return daoI.buscarEntidadId(id);}
    @Override
    public void guardarEntidad(CompProveedores proveedores){daoI.guardarEntidad(proveedores);}
    @Override
    public void eliminarEntidad(int id){daoI.eliminarEntidad(id);}
    @Override
    public void modificarEntidad(CompProveedores proveedores){daoI.modificarEntidad(proveedores);}     
}
