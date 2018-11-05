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
import pe.com.syscenterlife.dao.global.ManufacturaDaoI;
import pe.com.syscenterlife.modelo.GloManufactura;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author edwil
 */
@Service
@Transactional
public class ManufacturaServicioImpl implements ManufacturaServicioI{

    @Autowired
    public ManufacturaDaoI daoI;

    @Override
    public List<GloManufactura> listarEntidad(){return daoI.listarEntidad();}
    @Override    
    public List<GloManufactura> listarEntidadDato(String dato){return daoI.listarEntidadDato(dato);}
    @Override    
    public GloManufactura buscarEntidadId(int id){return daoI.buscarEntidadId(id);}
    @Override    
    public void guardarEntidad(GloManufactura manufactura){daoI.guardarEntidad(manufactura);}
    @Override    
    public void eliminarEntidad(int id){daoI.eliminarEntidad(id);}
    @Override    
    public void modificarEntidad(GloManufactura manufactura){daoI.modificarEntidad(manufactura);} 
}
