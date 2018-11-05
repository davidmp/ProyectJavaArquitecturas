/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.servicio.system;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.syscenterlife.dao.system.MenuDaoI;

import pe.com.syscenterlife.modelo.SysMenu;

/**
 *
 * @author LAB_SOFTWARE-DTI
 */
@Service
@Transactional
public class MenuServicioImpl implements MenuServicioI{
 
    @Autowired
    public MenuDaoI dao;
    
    @Override
    public List<SysMenu> listarMenu(){ return dao.listarMenu();}
    @Override
    public List<SysMenu> listarMenuDato(String dato){ return dao.listarMenuDato(dato);}
    @Override
    public SysMenu buscarMenuId(int id){return dao.buscarMenuId(id);}
    @Override
    public void guardarMenu(SysMenu menu){dao.guardarMenu(menu);}
    @Override
    public void eliminarMenu(int id){dao.eliminarMenu(id);}
    @Override
    public void modificarMenu(SysMenu menu){dao.modificarMenu(menu);}
}
