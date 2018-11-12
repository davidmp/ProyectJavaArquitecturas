/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.dao.global;

import java.util.List;
import pe.com.syscenterlife.modelo.GloPeriodo;

/**
 *
 * @author HEBERT
 */
public interface PeriodoDaoI {
    public List<GloPeriodo> listarEntidad();
    public List<GloPeriodo> listarEntidadDato(String dato);
    public List<GloPeriodo> listarEntidadProcedure(String dato);   
    public List<Object> operacionIgv (double monto);
    public GloPeriodo buscarEntidadId(int id);
    public void guardarEntidad(GloPeriodo periodo);
    public void eliminarEntidad(int id);
    public void modificarEntidad(GloPeriodo periodo);
}
