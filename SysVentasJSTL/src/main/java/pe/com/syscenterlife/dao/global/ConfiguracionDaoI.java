/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.dao.global;

import java.util.List;
import pe.com.syscenterlife.modelo.GloConfiguracion;


/**
 *
 * @author Juan Jose
 */
public interface ConfiguracionDaoI {
    public List<GloConfiguracion> listarEntidad();
    public List<GloConfiguracion> listarEntidadDato(String dato);
    public GloConfiguracion buscarEntidadId(int id);
    public void guardarEntidad(GloConfiguracion configuracion);
    public void eliminarEntidad(int id);
    public void modificarEntidad(GloConfiguracion configuracion);
}
