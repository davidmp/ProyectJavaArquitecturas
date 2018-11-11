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
import pe.com.syscenterlife.dao.global.CompanhiaDaoI;
import pe.com.syscenterlife.modelo.GloCompanhia;

/**
 *
 * @author pc
 */
@Service
@Transactional
public class CompanhiaServicioImpl implements CompanhiaServicioI{
    @Autowired
    public CompanhiaDaoI daoI;
    @Override
    public List<GloCompanhia> listarEntidad(){return daoI.listarEntidad();}
    @Override
    public List<GloCompanhia> listarEntidadDato(String dato){return daoI.listarEntidadDato(dato);}
    @Override
    public GloCompanhia buscarEntidadId(int id){return daoI.buscarEntidadId(id);}
    @Override
    public void guardarEntidad(GloCompanhia companhia){daoI.guardarEntidad(companhia);}
    @Override
    public void eliminarEntidad(int id){daoI.eliminarEntidad(id);}
    @Override
    public void modificarEntidad(GloCompanhia companhia){daoI.modificarEntidad(companhia);}
}
