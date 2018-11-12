/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.dao.system;

import java.util.List;
import org.springframework.stereotype.Repository;
import pe.com.syscenterlife.SysDataAccess;
import pe.com.syscenterlife.modelo.SysAccesos;
import pe.com.syscenterlife.modelo.ViewSysAccesos;

/**
 *
 * @author davidmp
 */
@Repository
public class AccesoDaoImpl extends SysDataAccess<Integer, SysAccesos> implements AccesoDaoI{
    
    @SuppressWarnings("unchecked")

    @Override
    public List<SysAccesos> listarEntidad(){return getListAll();}
    
    @Override
    public List<ViewSysAccesos> listarEntidadDato(int idUsuario){
        List<ViewSysAccesos> to=null;
        try {     
        to= (List<ViewSysAccesos>) sessionFactory.getCurrentSession()
               .createNativeQuery(" SELECT idAccesos,  nombre, url, nro_orden AS nroOrden,  codigo_seg AS codigoSeg, idMenu, (SELECT m.nombre  \n" +
                                " FROM sys_menu m  WHERE m.idMenu=a.idMenu) nombremenu, estado, estadopri  \n" +
                                " FROM (  SELECT a.idAccesos,a.nombre, a.url,a.idMenu,a.nro_orden, a.codigo_seg, \n" +
                                " (CASE WHEN b.estado='1' THEN b.estado ELSE '0' END)  estado, (CASE WHEN b.idUsuario IS NULL THEN '0' ELSE '1' END) estadopri  \n" +
                                " FROM (SELECT idAccesos,nombre, url,idMenu,nro_orden, codigo_seg FROM sys_accesos ) a LEFT JOIN ( SELECT idAccesos, idUsuario, "+
                                " estado FROM sys_privilegios WHERE idUsuario=?1 ) b USING(idAccesos)) a \n" +
                                " ORDER BY (SELECT m.etiqueta  FROM sys_menu m  WHERE m.idMenu=a.idMenu) ASC, nro_orden ASC ", ViewSysAccesos.class)
               .setParameter(1, idUsuario)
               .list();           
        }catch (Exception e) { logger.info("Mensage de Error en idPersonaGenerator() "+e.getMessage());   }
              
        return to;    
    }
    
    @Override
    public SysAccesos buscarEntidadId(int id){return getById(id);}
    @Override
    public void guardarEntidad(SysAccesos accesos){savev(accesos);}
    @Override
    public void eliminarentidad(int id){delete(id);}
    @Override
    public void modificarEntidad(SysAccesos accesos){update(accesos);}     
}
