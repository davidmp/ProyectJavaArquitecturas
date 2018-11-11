/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.servicio.global;

import java.util.List;
import pe.com.syscenterlife.modelo.GloCompanhia;

/**
 *
 * @author pc
 */
public interface CompanhiaServicioI {
    public List<GloCompanhia> listarEntidad();
    public List<GloCompanhia> listarEntidadDato(String dato);
    public GloCompanhia buscarEntidadId(int id);
    public void guardarEntidad(GloCompanhia companhia);
    public void eliminarEntidad(int id);
    public void modificarEntidad(GloCompanhia companhia);
}
