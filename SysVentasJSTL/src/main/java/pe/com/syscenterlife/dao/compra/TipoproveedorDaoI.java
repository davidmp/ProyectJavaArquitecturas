/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.dao.compra;

import java.util.List;
import pe.com.syscenterlife.modelo.CompTipoProveedor;


/**
 *
 * @author davidmp
 */
public interface TipoproveedorDaoI {
    public List<CompTipoProveedor> listarEntidad();
    public List<CompTipoProveedor> listarEntidadDato(String dato);
    public CompTipoProveedor buscarEntidadId(int id);
    public void guardarEntidad(CompTipoProveedor tipoProveedor);
    public void eliminarEntidad(int id);
    public void modificarEntidad(CompTipoProveedor tipoProveedor);       
}
