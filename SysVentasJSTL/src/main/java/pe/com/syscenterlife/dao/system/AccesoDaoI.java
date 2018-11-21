/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.dao.system;

import java.util.List;
import pe.com.syscenterlife.modelo.SysAccesos;
import pe.com.syscenterlife.modelo.ViewSysAccesos;

/**
 *
 * @author davidmp
 */
public interface AccesoDaoI {
    public List<SysAccesos> listarEntidad();
    public List<ViewSysAccesos> listarEntidadDato(int idUsuario);
    public SysAccesos buscarEntidadId(int id);
    public void guardarEntidad(SysAccesos accesos);
    public void eliminarentidad(int id);
    public void modificarEntidad(SysAccesos accesos);    
    public List<SysAccesos> listarNoombreAcceso();
    public List<SysAccesos> listarNoombreAccesoUsuario(int idUsuario);
}
