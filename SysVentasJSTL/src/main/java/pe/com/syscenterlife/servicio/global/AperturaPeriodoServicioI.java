/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.servicio.global;

import java.util.List;
import pe.com.syscenterlife.modelo.GloAperturaPeriodo;
/**
 *
 * @author HEBERT
 */
public interface AperturaPeriodoServicioI {
    public List<GloAperturaPeriodo> listarEntidad();
    public List<GloAperturaPeriodo> listarEntidadDato(String dato);
    public GloAperturaPeriodo buscarEntidadId(int id);
    public void guardarEntidad(GloAperturaPeriodo apper);
    public void eliminarEntidad(int id);
    public void modificarEntidad(GloAperturaPeriodo apper); 
}
