<%-- 
    Document   : mainPersona
    Created on : Aug 26, 2018, 9:25:55 PM
    Author     : davidmp
--%>

<%@page import="pe.edu.upeu.webappupeumvc.modelo.Persona"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel='stylesheet' href='../../webjars/bootstrap/4.1.2/css/bootstrap.min.css'>
        <script type='text/javascript' src='../../webjars/bootstrap/4.1.2/js/bootstrap.min.js'></script>        
    </head>
    <body>
        <h1>Hello World!</h1>
        <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">Show a Modal</button>
        <table class="table">
            <thead class="thead-dark">
            <tr>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>Dni</th>
                <th>Opciones</th>
            </tr>  
            </thead>
        <%
            List<Persona> lista=null;
            lista= (List<Persona>)session.getAttribute("ListaPersona");
            
        for (Persona per : lista) {

                %>
                

                    <tr>
                        <td><%=per.getNombre() %></td>
                        <td><%=per.getApellidos() %></td>
                        <td><%=per.getDni() %></td>
                        <td><a href="../../PersonaControl?idpersona=<%=per.getIdPersona() %>&opt=2" >Eliminar</a></td>
                    </tr>
                         
        
                    <%
                    }
                    %>     

        </table>        
        
    </body>
</html>
