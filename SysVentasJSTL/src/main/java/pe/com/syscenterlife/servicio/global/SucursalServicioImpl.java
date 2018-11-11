/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.servicio.global;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.syscenterlife.dao.global.SucursalDaoI;
import pe.com.syscenterlife.modelo.GloSucursal;
/**
 *
 * @author pc
 */
@Service
@Transactional
public class SucursalServicioImpl implements SucursalServicioI{
    
@Autowired
public SucursalDaoI daoI;

@Override
    public List<GloSucursal> listarEntidad(){return daoI.listarEntidad();}
@Override
    public List<GloSucursal> listarEntidadDato(String dato){return daoI.listarEntidadDato(dato);}
@Override
    public GloSucursal buscarEntidadId(int id){return daoI.buscarEntidadId(id);}
@Override
    public void guardarEntidad(GloSucursal sucursal){daoI.guardarEntidad(sucursal);}   
@Override
    public void eliminarEntidad(int id){daoI.eliminarEntidad(id);}   
@Override
    public void modificarEntidad(GloSucursal sucursal){daoI.modificarEntidad(sucursal);}
}
