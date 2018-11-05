/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.dao.global;

import java.util.List;
import pe.com.syscenterlife.modelo.GloCategoriaProducto;

/**
 *
 * @author Juan Jose
 */
public interface CategoriaProDaoI {
    public List<GloCategoriaProducto> listarEntidad();
    public List<GloCategoriaProducto> listarEntidadDato(String dato);
    public GloCategoriaProducto buscarEntidadId(int id);
    public void guardarEntidad(GloCategoriaProducto categoria);
    public void eliminarEntidad(int id);
    public void modificarEntidad(GloCategoriaProducto categoria);
}
