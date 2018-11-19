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
import pe.com.syscenterlife.dao.global.PersonaDaoI;

import pe.com.syscenterlife.modelo.GloPersonas;
import pe.com.syscenterlife.modelo.IdGenerator;

/**
 *
 * @author LAB_SOFTWARE-DTI
 */
@Service
@Transactional
public class PersonaServicioImpl implements PersonaServicioI{
 
    @Autowired
    public PersonaDaoI dao;
    
    @Override
    public List<GloPersonas> listarEntidad(){ return dao.listarEntidad();}
    @Override
    public List<GloPersonas> listarEntidadDato(String dato){ return dao.listarEntidadDato(dato);}
    @Override
    public GloPersonas buscarEntidadId(int id){return dao.buscarEntidadId(id);}
    @Override
    public void guardarEntidad(GloPersonas persona){dao.guardarEntidad(persona);}
    @Override
    public void eliminarEntidad(int id){dao.eliminarEntidad(id);}
    @Override
    public void modificarEntidad(GloPersonas persona){dao.modificarEntidad(persona);}
    
    @Override
    public IdGenerator idPersonaGenerator(){ return dao.idPersonaGenerator();  }
    @Override
    public GloPersonas validarLogin(GloPersonas user){ return dao.validarLogin(user);  }
    
}
