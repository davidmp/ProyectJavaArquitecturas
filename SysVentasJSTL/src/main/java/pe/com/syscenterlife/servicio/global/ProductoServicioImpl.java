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
import pe.com.syscenterlife.dao.global.ProductoDaoI;
import pe.com.syscenterlife.modelo.GloProductos;

/**
 *
 * @author quiroga
 */
@Service
@Transactional
public class ProductoServicioImpl implements ProductoServicioI{
    
   @Autowired
   public ProductoDaoI dao;

    @Override
    public List<GloProductos> listarEntidad() {
        return dao.listarEntidad(); 
    }

    @Override
    public List<GloProductos> listarEntidadDato(String dato) {
        return dao.listarEntidadDato(dato); 
    }

    @Override
    public GloProductos buscarEntidadId(int id) {
        return dao.buscarEntidadId(id);
    }

    @Override
    public void guardarEntidad(GloProductos producto) {
        dao.guardarEntidad(producto); 
    }

    @Override
    public void eliminarEntidad(int id) {
        dao.eliminarEntidad(id); 
    }

    @Override
    public void modificarEntidad(GloProductos producto) {
        dao.modificarEntidad(producto); 
    }
    
}
