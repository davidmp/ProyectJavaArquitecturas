/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.servicio.system;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.syscenterlife.dao.system.AccesoDaoI;
import pe.com.syscenterlife.modelo.SysAccesos;
import pe.com.syscenterlife.modelo.ViewSysAccesos;

/**
 *
 * @author davidmp
 */
@Service
@Transactional
public class AccesoServicioImpl implements AccesoServicioI{
 
    @Autowired
    public AccesoDaoI dao;
    
    @Override
    public List<SysAccesos> listarEntidad(){return dao.listarEntidad();}
    @Override
    public List<ViewSysAccesos> listarEntidadDato(int idUsuario){return dao.listarEntidadDato(idUsuario);}
    @Override
    public SysAccesos buscarEntidadId(int id){return dao.buscarEntidadId(id);}
    @Override
    public void guardarEntidad(SysAccesos accesos){dao.guardarEntidad(accesos);}
    @Override
    public void eliminarentidad(int id){dao.eliminarentidad(id);}
    @Override
    public void modificarEntidad(SysAccesos accesos){dao.modificarEntidad(accesos);}
    
    @Override
    public List<SysAccesos> listarNoombreAcceso(){return dao.listarNoombreAcceso();}
    @Override
    public List<SysAccesos> listarNoombreAccesoUsuario(int idUsuario){return dao.listarNoombreAccesoUsuario(idUsuario);}
    
}
