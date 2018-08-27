<%-- 
    Document   : index
    Created on : Aug 26, 2018, 10:37:24 PM
    Author     : davidmp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel='stylesheet' href='webjars/bootstrap/4.1.2/css/bootstrap.min.css'>
        <script type='text/javascript' src='webjars/bootstrap/4.1.2/js/bootstrap.min.js'></script>
    
        
         
    </head>
    <body>
        <h1>Hello World!</h1>
        <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">Show a Modal</button>
        <a href="/WebAppUPeUMVC/PersonaControl?opt=1" class="btn btn-primary btn-lg active" role="button" aria-pressed="true" >Ir Persona</a>
        <a href="/WebAppUPeUMVC/EstudianteControl?opt=1" class="btn btn-primary btn-lg active" role="button" aria-pressed="true" >Ir Estudiante</a>        
    </body>
</html>
