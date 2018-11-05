/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.servicio.global;

import java.util.List;
import pe.com.syscenterlife.modelo.GloUnidadmedProducto;

/**
 *
 * @author quiroga
 */
public interface UmedidaproductoServicioI {
    public List<GloUnidadmedProducto> listarEntidad();
    public List<GloUnidadmedProducto> listarEntidadDato(String dato);
    public GloUnidadmedProducto buscarEntidadId(int id);
    public void guardarEntidad(GloUnidadmedProducto unidadmedProducto);
    public void eliminarEntidad(int id);
    public void modificarEntidad(GloUnidadmedProducto unidadmedProducto);

    
}
