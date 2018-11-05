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
import pe.com.syscenterlife.dao.global.UnidadmedidaDaoI;
import pe.com.syscenterlife.modelo.GloUnidadMedida;


/**
 *
 * @author quiroga
 */
@Service
@Transactional
public class UnidadmedidaServicioImpl implements UnidadmedidaServicioI{
    
    @Autowired
    public UnidadmedidaDaoI dao;

    @Override
    public List<GloUnidadMedida> listarEntidad() {
        return dao.listarEntidad(); 
    }

    @Override
    public List<GloUnidadMedida> listarEntidadDato(String dato) {
        return dao.listarEntidadDato(dato); 
    }

    @Override
    public GloUnidadMedida buscarEntidadId(int id) {
        return dao.buscarEntidadId(id); 
    }

    @Override
    public void guardarEntidad(GloUnidadMedida unidadMedida) {
        dao.guardarEntidad(unidadMedida); 
    }

    @Override
    public void eliminarEntidad(int id) {
        dao.eliminarEntidad(id); 
    }

    @Override
    public void modificarEntidad(GloUnidadMedida unidadMedida) {
        dao.modificarEntidad(unidadMedida); 
    }
    
    
}
