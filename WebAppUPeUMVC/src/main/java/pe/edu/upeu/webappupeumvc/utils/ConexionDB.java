/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.webappupeumvc.utils;

/**
 *
 * @author LAB_SOFTWARE-DTI
 */
import com.mysql.jdbc.Driver;
import java.sql.*;
public class ConexionDB {
    public Connection con=null;
    public PreparedStatement ps=null;
    public ResultSet rs=null;
            
    public void getConexionDB(){
        try {
            DriverManager.registerDriver(new Driver());
            if(con==null){
            con=DriverManager.getConnection("jdbc:mysql://127.0.0.1/academico", "root", "");
            System.out.println("conexion exitosa"+con);
            }
        } catch (Exception e) {
            System.out.println("Error en la conexion " +e.getMessage());
        }
    }
    
    
    public void getCerrarConexionDB(){
        try {
            if(ps!=null){ps.close();}
            if(rs!=null){rs.close();}
            if(con!=null){con.close();}
        } catch (Exception e) {
        }
    }
    
    public static void main(String[] args) {
        ConexionDB cx=new ConexionDB();
        cx.getConexionDB();
    }
    
}
