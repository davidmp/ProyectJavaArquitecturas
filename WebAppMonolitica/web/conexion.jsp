        
<%@page import="java.sql.*"%>
<%
Connection conexion=null;
try{
Class.forName("com.mysql.jdbc.Driver");
conexion=DriverManager.getConnection
("jdbc:mysql://127.0.0.1/academico","root","");
out.println("Conexi�n realizada con �xito a: "+conexion.getCatalog());

} catch(SQLException ex)
{ %>
<%="Se produjo una excepci�n durante la conexi�n:"+ex%>
<%} catch(Exception ex){ %>
<%="Se produjo una excepci�n:"+ex%>

<%}%>   