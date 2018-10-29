/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.dao.global;

import java.util.List;
import pe.com.syscenterlife.modelo.GloPersonas;

/**
 *
 * @author LAB_SOFTWARE-DTI
 */
public interface PersonaDaoI {
    public List<GloPersonas> listarEntidad();
    public List<GloPersonas> listarEntidadDato(String dato);
    public GloPersonas buscarEntidadId(int id);
    public void guardarEntidad(GloPersonas persona);
    public void eliminarEntidad(int id);
    public void modificarEntidad(GloPersonas persona);
}
