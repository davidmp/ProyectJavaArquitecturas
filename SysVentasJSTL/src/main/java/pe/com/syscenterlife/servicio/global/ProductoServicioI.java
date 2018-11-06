/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.servicio.global;

import java.util.List;
import pe.com.syscenterlife.modelo.GloProductos;
import pe.com.syscenterlife.modelo.IdGenerator;

/**
 *
 * @author quiroga
 */
public interface ProductoServicioI {
    public List<GloProductos> listarEntidad();
    public List<GloProductos> listarEntidadDato(String dato);
    public GloProductos buscarEntidadId(int id);
    public void guardarEntidad(GloProductos producto);
    public void eliminarEntidad(int id);
    public void modificarEntidad(GloProductos producto);
    
}
