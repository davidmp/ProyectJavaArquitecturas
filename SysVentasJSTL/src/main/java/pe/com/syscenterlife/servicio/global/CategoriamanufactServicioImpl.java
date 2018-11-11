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
import pe.com.syscenterlife.dao.global.CategoriamanufactDaoI;
import pe.com.syscenterlife.modelo.GloCategoriamanufact;

/**
 *
 * @author davidmp
 */
@Service
@Transactional
public class CategoriamanufactServicioImpl implements CategoriamanufactServicioI{
 
@Autowired
public CategoriamanufactDaoI daoI;

    @Override
    public List<GloCategoriamanufact> listarEntidad(){return daoI.listarEntidad();}
    @Override    
    public List<GloCategoriamanufact> listarEntidadDato(String dato){return daoI.listarEntidadDato(dato);}
    @Override    
    public GloCategoriamanufact buscarEntidadId(int id){return daoI.buscarEntidadId(id);}
    @Override    
    public void guardarEntidad(GloCategoriamanufact categoriamanufact){daoI.guardarEntidad(categoriamanufact);}
    @Override    
    public void eliminarEntidad(int id){daoI.eliminarEntidad(id);}
    @Override    
    public void modificarEntidad(GloCategoriamanufact categoriamanufact){daoI.modificarEntidad(categoriamanufact);} 
}
