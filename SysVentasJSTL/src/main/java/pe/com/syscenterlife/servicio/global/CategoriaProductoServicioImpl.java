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
import pe.com.syscenterlife.dao.global.CategoriaProDaoI;
import pe.com.syscenterlife.modelo.GloCategoriaProducto;

/**
 *
 * @author Student
 */
@Service
@Transactional
public class CategoriaProductoServicioImpl implements CategoriaProductoServicioI{
    
    @Autowired
    public CategoriaProDaoI dao;

    @Override
    public List<GloCategoriaProducto> listarEntidad(){return dao.listarEntidad();} 
        
   
    @Override
    public List<GloCategoriaProducto> listarEntidadDato(String dato) {return dao.listarEntidadDato(dato);}
      
    
    @Override
    public GloCategoriaProducto buscarEntidadId(int id) {return dao.buscarEntidadId(id);}
       
    
    @Override
    public void guardarEntidad(GloCategoriaProducto categoria) {dao.guardarEntidad(categoria);}
    

    @Override
    public void eliminarEntidad(int id) {dao.eliminarEntidad(id);}
    

    @Override
    public void modificarEntidad(GloCategoriaProducto categoria) {dao.modificarEntidad(categoria);}
}

