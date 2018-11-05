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
import pe.com.syscenterlife.dao.global.ConfiguracionDaoI;


import pe.com.syscenterlife.modelo.GloConfiguracion;


/**
 *
 * @author Juan Jose
 */
@Service
@Transactional
public class ConfiguracionServicioImpl implements ConfiguracionServicioI{
     
    @Autowired
    public ConfiguracionDaoI daoI;
    
    @Override
    public List<GloConfiguracion> listarEntidad(){ return daoI.listarEntidad();}
    @Override
    public List<GloConfiguracion> listarEntidadDato(String dato){ return daoI.listarEntidadDato(dato);}
    @Override
    public GloConfiguracion buscarEntidadId(int id){return daoI.buscarEntidadId(id);}
    @Override
    public void guardarEntidad(GloConfiguracion configuracion){daoI.guardarEntidad(configuracion);}
    @Override
    public void eliminarEntidad(int id){daoI.eliminarEntidad(id);}
    @Override
    public void modificarEntidad(GloConfiguracion configuracion){daoI.modificarEntidad(configuracion);}
    
    
    
}
