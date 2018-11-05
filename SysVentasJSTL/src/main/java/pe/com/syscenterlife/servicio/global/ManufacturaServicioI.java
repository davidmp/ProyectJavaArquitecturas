/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.servicio.global;

import java.util.List;
import pe.com.syscenterlife.modelo.GloManufactura;

/**
 *
 * @author edwil
 */
public interface ManufacturaServicioI {
    public List<GloManufactura> listarEntidad();
    public List<GloManufactura> listarEntidadDato(String dato);
    public GloManufactura buscarEntidadId(int id);
    public void guardarEntidad(GloManufactura manufactura);
    public void eliminarEntidad(int id);
    public void modificarEntidad(GloManufactura manufactura);
}
