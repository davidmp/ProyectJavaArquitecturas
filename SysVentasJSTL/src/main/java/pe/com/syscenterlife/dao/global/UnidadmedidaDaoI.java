/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.dao.global;

import java.util.List;
import pe.com.syscenterlife.modelo.GloUnidadMedida;

/**
 *
 * @author quiroga
 */
public interface UnidadmedidaDaoI {
    public List<GloUnidadMedida> listarEntidad();
    public List<GloUnidadMedida> listarEntidadDato(String dato);
    public GloUnidadMedida buscarEntidadId(int id);
    public void guardarEntidad(GloUnidadMedida unidadMedida);
    public void eliminarEntidad(int id);
    public void modificarEntidad(GloUnidadMedida unidadMedida);
}
