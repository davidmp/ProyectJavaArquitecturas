<%-- 
    Document   : personaMain
    Created on : 13/08/2018, 09:55:10 AM
    Author     : LAB_SOFTWARE-DTI
--%>

<%@page import="java.sql.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <%
        Connection conexion=null;
        try{
        Class.forName("com.mysql.jdbc.Driver");
        conexion=DriverManager.getConnection
        ("jdbc:mysql://127.0.0.1/academico","root","");
        out.println("Conexión realizada con éxito a: "+conexion.getCatalog());
        
        } catch(SQLException ex)
        { %>
        <%="Se produjo una excepción durante la conexión:"+ex%>
        <%} catch(Exception ex){ %>
        <%="Se produjo una excepción:"+ex%>
        
        <%}%>   
        
        <%
        PreparedStatement ps=conexion.prepareStatement("SELECT * FROM persona");
        ResultSet rs=ps.executeQuery();
        %>
        <table>
            <tr>
                <td>nombre</td>
                <td>apellidos</td>
                <td>dni</td>
                <td>Opciones</td>
            </tr>            
        <%
        while (rs.next()) {
                //Object elem = rs.next();
                %>
                

                    <tr>
                        <td><%=rs.getString("nombre") %></td>
                        <td><%=rs.getString("apellidos") %></td>
                        <td><%=rs.getString("dni") %></td>
                        <td><a href="personaMain.jsp?idpersona=<%=rs.getInt("idPersona") %>&opc=D" >Eliminar</a></td>
                    </tr>
                         
        
                
        <%              
        }        
        conexion.close();
        %>
        </table>
    </body>
</html>
