/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.webappupeumvc.dao;

import java.util.ArrayList;
import java.util.List;
import pe.edu.upeu.webappupeumvc.modelo.Persona;
import pe.edu.upeu.webappupeumvc.utils.ConexionDB;

/**
 *
 * @author LAB_SOFTWARE-DTI
 */
public class PersonaDAO extends ConexionDB{
   
  public List listarPersona(){
      List<Persona> personaTO=new ArrayList<>();
      Persona to;
      getConexionDB();
      try {
          ps=con.prepareStatement("select * from persona");
          rs=ps.executeQuery();
          while(rs.next()){
          to=new Persona();
          to.setIdPersona(rs.getInt("idPersona"));
          to.setNombre(rs.getString("nombre"));
          to.setApellidos(rs.getString("apellidos"));
          to.setDni(rs.getString("dni"));
          to.setTelefono(rs.getString("telefono"));
          personaTO.add(to);
              System.out.println("Reporte Persona Nombre:"+rs.getString("nombre"));          
          }
      } catch (Exception e) {
          System.out.println("Erro en listar persona "+e.getMessage());
      }
      finally{
      getCerrarConexionDB();
      }      
      return personaTO;
  }
  /*
    public static void main(String[] args) {
        PersonaDAO dao=new PersonaDAO();
        dao.listarPersona();
    }  */

}
