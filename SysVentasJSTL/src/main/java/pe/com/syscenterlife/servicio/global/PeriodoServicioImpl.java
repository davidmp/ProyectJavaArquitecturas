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
import pe.com.syscenterlife.dao.global.PeriodoDaoI;
import pe.com.syscenterlife.modelo.GloPeriodo;

/**
 *
 * @author HEBERT
 */
@Service
@Transactional
public class PeriodoServicioImpl implements PeriodoServicioI{
    
    @Autowired
    public PeriodoDaoI daoI;    
    @Override
    public List<GloPeriodo> listarEntidad(){return daoI.listarEntidad();}
    @Override
    public List<GloPeriodo> listarEntidadDato(String dato){return daoI.listarEntidadDato(dato);}
    @Override
    public List<GloPeriodo> listarEntidadProcedure(String dato){return daoI.listarEntidadProcedure(dato);}
    
    @Override
    public List<Object> operacionIgv (double monto){return daoI.operacionIgv(monto);}
    
    @Override
    public GloPeriodo buscarEntidadId(int id){return daoI.buscarEntidadId(id);}
    @Override
    public void guardarEntidad(GloPeriodo periodo){daoI.guardarEntidad(periodo);}
    @Override
    public void eliminarEntidad(int id){daoI.eliminarEntidad(id);}
    @Override
    public void modificarEntidad(GloPeriodo periodo){daoI.modificarEntidad(periodo);}   
}
