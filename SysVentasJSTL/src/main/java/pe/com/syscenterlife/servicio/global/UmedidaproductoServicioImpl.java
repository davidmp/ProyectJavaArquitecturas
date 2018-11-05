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
import pe.com.syscenterlife.dao.global.UmedidaproductoDaoI;
import pe.com.syscenterlife.modelo.GloUnidadmedProducto;


/**
 *
 * @author quiroga
 */
@Service
@Transactional
public class UmedidaproductoServicioImpl implements UmedidaproductoServicioI{
    
    @Autowired
    public UmedidaproductoDaoI dao;

    @Override
    public List<GloUnidadmedProducto> listarEntidad() {
        return dao.listarEntidad(); 
    }

    @Override
    public List<GloUnidadmedProducto> listarEntidadDato(String dato) {
        return dao.listarEntidadDato(dato); 
    }

    @Override
    public GloUnidadmedProducto buscarEntidadId(int id) {
        return dao.buscarEntidadId(id);
    }

    @Override
    public void guardarEntidad(GloUnidadmedProducto unidadmedProducto) {
        dao.guardarEntidad(unidadmedProducto); 
    }

    @Override
    public void eliminarEntidad(int id) {
        dao.eliminarEntidad(id);
    }

    @Override
    public void modificarEntidad(GloUnidadmedProducto unidadmedProducto) {
        dao.modificarEntidad(unidadmedProducto);
    }

   
}
