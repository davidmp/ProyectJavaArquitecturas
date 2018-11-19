/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.servicio.global;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.syscenterlife.dao.global.UsuarioDaoI;
import pe.com.syscenterlife.modelo.GloPersonas;
import pe.com.syscenterlife.modelo.GloUsuario;
import pe.com.syscenterlife.modelo.IdGenerator;

/**
 *
 * @author davidmp
 */
@Service
@Transactional
public class UsuarioServicioImpl implements UsuarioServicioI{
    
    @Autowired
    public UsuarioDaoI dao; 
    @Override
    public List<GloUsuario> listarEntidad(){ return dao.listarEntidad();}
    @Override
    public List<GloUsuario> listarEntidadDato(String dato){ return dao.listarEntidadDato(dato);}
    @Override
    public GloUsuario buscarEntidadId(int id){return dao.buscarEntidadId(id);}
    @Override
    public void guardarEntidad(GloUsuario persona){dao.guardarEntidad(persona);}
    @Override
    public void eliminarEntidad(int id){dao.eliminarEntidad(id);}
    @Override
    public void modificarEntidad(GloUsuario persona){dao.modificarEntidad(persona);}
    
    @Override
    public IdGenerator idUsuarioGenerator(){ return dao.idUsuarioGenerator();  }
    
    @Override
    public GloUsuario validarLogin(GloPersonas user){ return dao.validarLogin(user);  }   
    @Override
    public List<GloUsuario> validarUsuario(GloPersonas user){return dao.validarUsuario(user);}
}
