/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.dao.system;

import java.util.List;
import org.springframework.stereotype.Repository;
import pe.com.syscenterlife.SysDataAccess;
import pe.com.syscenterlife.modelo.SysMenu;

/**
 *
 * @author LAB_SOFTWARE-DTI
 */
@Repository
public class MenuDaoImpl extends SysDataAccess<Integer, SysMenu> implements MenuDaoI{
    
    @SuppressWarnings("unchecked")
    
    @Override
    public List<SysMenu> listarMenu(){ return getListAll();}    
        
    
    @Override
    public List<SysMenu> listarMenuDato(String dato){
        return (List<SysMenu>)sessionFactory.getCurrentSession()
                .createQuery("SELECT p from SysMenu p WHERE p.nombre LIKE ?1 ")
                .setParameter(1, "%"+dato+"%")
                .list();                
                }
    
    @Override
    public SysMenu buscarMenuId(int id){ return getById(id);}
    
    @Override
    public void guardarMenu(SysMenu menu){savev(menu);}
    @Override
    public void eliminarMenu(int id){delete(id);}
    @Override
    public void modificarMenu(SysMenu menu){update(menu);}

}
