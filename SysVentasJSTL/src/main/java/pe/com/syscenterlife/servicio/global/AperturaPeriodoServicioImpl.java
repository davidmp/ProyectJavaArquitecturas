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
import pe.com.syscenterlife.dao.global.AperturaPeriodoDaoI;

import pe.com.syscenterlife.modelo.GloAperturaPeriodo;

/**
 *
 * @author HEBERT
 */
@Service
@Transactional
public class AperturaPeriodoServicioImpl implements AperturaPeriodoServicioI {
    
    @Autowired
    public AperturaPeriodoDaoI dao;
    
    @Override
    public List<GloAperturaPeriodo> listarEntidad(){ return dao.listarEntidad();}
    @Override
    public List<GloAperturaPeriodo> listarEntidadDato(String dato){ return dao.listarEntidadDato(dato);}
    @Override
    public GloAperturaPeriodo buscarEntidadId(int id){return dao.buscarEntidadId(id);}
    @Override
    public void guardarEntidad(GloAperturaPeriodo apper){dao.guardarEntidad(apper);}
    @Override
    public void eliminarEntidad(int id){dao.eliminarEntidad(id);}
    @Override
    public void modificarEntidad(GloAperturaPeriodo apper){dao.modificarEntidad(apper);}
}
