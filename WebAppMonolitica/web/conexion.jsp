        
<%@page import="java.sql.*"%>
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