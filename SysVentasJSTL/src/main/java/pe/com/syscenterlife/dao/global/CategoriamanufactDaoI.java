/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.dao.global;


import java.util.List;
import pe.com.syscenterlife.modelo.GloCategoriamanufact;

/**
 *
 * @author LAB_SOFTWARE-DTI
 */
public interface CategoriamanufactDaoI {
    public List<GloCategoriamanufact> listarEntidad();
    public List<GloCategoriamanufact> listarEntidadDato(String dato);
    public GloCategoriamanufact buscarEntidadId(int id);
    public void guardarEntidad(GloCategoriamanufact categoriamanufact);
    public void eliminarEntidad(int id);
    public void modificarEntidad(GloCategoriamanufact categoriamanufact);    
}
