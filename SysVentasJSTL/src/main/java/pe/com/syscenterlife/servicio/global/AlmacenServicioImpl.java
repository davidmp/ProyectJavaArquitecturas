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
import pe.com.syscenterlife.dao.global.AlmacenDaoI;
import pe.com.syscenterlife.modelo.GloAlmacen;

/**
 *
 * @author HEBERT
 */
@Service
@Transactional
public class AlmacenServicioImpl implements AlmacenServicioI{
    
    @Autowired
    public AlmacenDaoI daoI;    
    @Override
    public List<GloAlmacen> listarEntidad(){return daoI.listarEntidad();}
    @Override
    public List<GloAlmacen> listarEntidadDato(String dato){return daoI.listarEntidadDato(dato);}
    @Override
    public int operacionProcedure(int id){return daoI.operacionProcedure(id);}
    @Override
    public GloAlmacen buscarEntidadId(int id){return daoI.buscarEntidadId(id);}
    @Override
    public void guardarEntidad(GloAlmacen almacen){daoI.guardarEntidad(almacen);}
    @Override
    public void eliminarEntidad(int id){daoI.eliminarEntidad(id);}
    @Override
    public void modificarEntidad(GloAlmacen almacen){daoI.modificarEntidad(almacen);}
}
