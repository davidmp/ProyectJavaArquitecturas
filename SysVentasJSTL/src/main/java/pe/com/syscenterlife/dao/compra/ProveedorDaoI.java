/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.dao.compra;

import java.util.List;
import pe.com.syscenterlife.modelo.CompProveedores;

/**
 *
 * @author LAB_SOFTWARE-DTI
 */
public interface ProveedorDaoI {
    public List<CompProveedores> listarEntidad();
    public List<CompProveedores> listarEntidadDato(String dato);
    public CompProveedores buscarEntidadId(int id);
    public void guardarEntidad(CompProveedores proveedores);
    public void eliminarEntidad(int id);
    public void modificarEntidad(CompProveedores proveedores);    
}
