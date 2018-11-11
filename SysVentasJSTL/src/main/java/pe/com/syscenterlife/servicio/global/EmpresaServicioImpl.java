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
import pe.com.syscenterlife.dao.global.EmpresaDaoI;
import pe.com.syscenterlife.modelo.GloEmpresa;

/**
 *
 * @author pc
 */
@Service
@Transactional
public class EmpresaServicioImpl implements EmpresaServicioI{
  @Autowired
 public EmpresaDaoI daoI;
  @Override
    public List<GloEmpresa> listarEntidad(){return daoI.listarEntidad();}
  @Override
    public List<GloEmpresa> listarEntidadDato(String dato){return daoI.listarEntidadDato(dato);}
  @Override
    public GloEmpresa buscarEntidadId(int id){return daoI.buscarEntidadId(id);}
  @Override
    public void guardarEntidad(GloEmpresa empresa){daoI.guardarEntidad(empresa);}
  @Override
    public void eliminarEntidad(int id){daoI.eliminarEntidad(id);}
  @Override
    public void modificarEntidad(GloEmpresa empresa){daoI.modificarEntidad(empresa);}
}
