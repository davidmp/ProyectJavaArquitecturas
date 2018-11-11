/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.servicio.global;

import java.util.List;
import pe.com.syscenterlife.modelo.GloEmpresa;

/**
 *
 * @author pc
 */
public interface EmpresaServicioI {
    public List<GloEmpresa> listarEntidad();
    public List<GloEmpresa> listarEntidadDato(String dato);
    public GloEmpresa buscarEntidadId(int id);
    public void guardarEntidad(GloEmpresa empresa);
    public void eliminarEntidad(int id);
    public void modificarEntidad(GloEmpresa empresa);  
}
