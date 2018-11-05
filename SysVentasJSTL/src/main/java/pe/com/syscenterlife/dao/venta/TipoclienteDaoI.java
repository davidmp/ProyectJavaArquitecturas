/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.dao.venta;

import java.util.List;
import pe.com.syscenterlife.modelo.VentTipoCliente;


public interface TipoclienteDaoI {
    public List<VentTipoCliente> listarEntidad();
    public List<VentTipoCliente> listarEntidadDato(String dato);
    public VentTipoCliente buscarEntidadId(int id);
    public void guardarEntidad(VentTipoCliente tipoCliente);
    public void eliminarEntidad(int id);
    public void modificarEntidad(VentTipoCliente tipoCliente);
}
