/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.dao.system;

import java.util.List;
import pe.com.syscenterlife.modelo.SysMenu;

/**
 *
 * @author LAB_SOFTWARE-DTI
 */
public interface MenuDaoI {
    public List<SysMenu> listarMenu();
    public List<SysMenu> listarMenuDato(String dato);
    public SysMenu buscarMenuId(int id);
    public void guardarMenu(SysMenu menu);
    public void eliminarMenu(int id);
    public void modificarMenu(SysMenu menu);
}
