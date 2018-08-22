/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.webappupeumvc.dao;

import java.util.List;
import pe.edu.upeu.webappupeumvc.utils.ConexionDB;

/**
 *
 * @author LAB_SOFTWARE-DTI
 */
public class PersonaDAO extends ConexionDB{
   
  public List listarPersona(){
      
      getConexionDB();
      try {
          ps=con.prepareStatement("");
      } catch (Exception e) {
      }
      
      
      return null;
  }
    
}
