/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.dao.global;

import java.util.List;
import pe.com.syscenterlife.modelo.GloPersonas;
import pe.com.syscenterlife.modelo.GloUsuario;
import pe.com.syscenterlife.modelo.IdGenerator;

/**
 *
 * @author davidmp
 */
public interface UsuarioDaoI {
    public List<GloUsuario> listarEntidad();
    public List<GloUsuario> listarEntidadDato(String dato);
    public GloUsuario buscarEntidadId(int id);
    public GloUsuario validarLogin(GloPersonas user);
    public void guardarEntidad(GloUsuario usuario);
    public void eliminarEntidad(int id);
    public void modificarEntidad(GloUsuario usuario);
    public IdGenerator idUsuarioGenerator();   
    public List<GloUsuario> validarUsuario(GloPersonas user);
}
