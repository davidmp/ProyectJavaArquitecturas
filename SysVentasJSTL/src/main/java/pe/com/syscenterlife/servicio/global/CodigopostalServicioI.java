/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.servicio.global;

import java.util.List;
import pe.com.syscenterlife.modelo.GloCodigopostal;

/**
 *
 * @author davidmp
 */
public interface CodigopostalServicioI {
    public List<GloCodigopostal> listarEntidad();
    public List<GloCodigopostal> listarEntidadDato(String dato);
    public GloCodigopostal buscarEntidadId(int id);
    public void guardarEntidad(GloCodigopostal codigopostal);
    public void eliminarEntidad(int id);
    public void modificarEntidad(GloCodigopostal codigopostal);    
}
