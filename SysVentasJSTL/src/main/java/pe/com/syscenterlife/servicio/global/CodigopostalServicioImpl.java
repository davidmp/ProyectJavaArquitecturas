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
import pe.com.syscenterlife.dao.global.CodigopostalDaoI;
import pe.com.syscenterlife.modelo.GloCodigopostal;

/**
 *
 * @author davidmp
 */
@Service
@Transactional
public class CodigopostalServicioImpl implements CodigopostalServicioI{
 
@Autowired
public CodigopostalDaoI daoI;

    @Override
    public List<GloCodigopostal> listarEntidad(){return daoI.listarEntidad();}
    @Override    
    public List<GloCodigopostal> listarEntidadDato(String dato){return daoI.listarEntidadDato(dato);}
    @Override    
    public GloCodigopostal buscarEntidadId(int id){return daoI.buscarEntidadId(id);}
    @Override    
    public void guardarEntidad(GloCodigopostal codigopostal){daoI.guardarEntidad(codigopostal);}
    @Override    
    public void eliminarEntidad(int id){daoI.eliminarEntidad(id);}
    @Override    
    public void modificarEntidad(GloCodigopostal codigopostal){daoI.modificarEntidad(codigopostal);} 
}
