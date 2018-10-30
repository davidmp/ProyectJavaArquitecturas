/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.dao.compra;

import java.util.List;
import org.springframework.stereotype.Repository;
import pe.com.syscenterlife.SysDataAccess;
import pe.com.syscenterlife.modelo.CompTipoProveedor;

/**
 *
 * @author davidmp
 */
@Repository
public class TipoproveedorDaoImpl extends SysDataAccess<Integer, CompTipoProveedor> implements TipoproveedorDaoI{
        @SuppressWarnings("unchecked") 
        
        @Override
        public List<CompTipoProveedor> listarEntidad(){return getListAll();}
        @Override        
        public List<CompTipoProveedor> listarEntidadDato(String dato){return null;}
        @Override        
        public CompTipoProveedor buscarEntidadId(int id){return getById(id);}
        @Override        
        public void guardarEntidad(CompTipoProveedor tipoProveedor){savev(tipoProveedor);}
        @Override        
        public void eliminarEntidad(int id){delete(id);}
        @Override        
        public void modificarEntidad(CompTipoProveedor tipoProveedor){update(tipoProveedor);}
    
}
