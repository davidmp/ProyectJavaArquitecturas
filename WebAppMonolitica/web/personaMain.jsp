<%-- 
    Document   : personaMain
    Created on : 13/08/2018, 09:55:10 AM
    Author     : LAB_SOFTWARE-DTI
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="conexion.jsp" %>
    </head>
    <body>
        <h1>Hello World!</h1>
        

        
        <%
        String opc=request.getParameter("opc")==null?"":request.getParameter("opc");
        
        if(opc.equals("D")){
        int idpersona=Integer.parseInt(request.getParameter("idpersona")==null?"0":request.getParameter("idpersona"));
        PreparedStatement psx=conexion.prepareStatement("delete from persona where idPersona='"+idpersona+"'");
        psx.executeUpdate();
        }

        %>
        
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
