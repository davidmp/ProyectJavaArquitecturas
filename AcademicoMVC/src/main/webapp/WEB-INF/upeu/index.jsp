<%-- 
    Document   : index
    Created on : 29/08/2018, 12:56:09 PM
    Author     : LAB_SOFTWARE-DTI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel='stylesheet' href='resources/bootstrap/4.1.2/css/bootstrap.min.css'>
        <script type='text/javascript' src='resources/bootstrap/4.1.2/js/bootstrap.min.js'></script>
        
        <link rel="stylesheet" href="resources/jquery/jquery-ui.css">        
        <script type='text/javascript' src='webjars/jquery/3.3.1/dist/jquery.min.js'></script>
        
        
<!--Import Google Icon Font-->
      <link href="resources/materializer/material.css" rel="stylesheet">        
        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="webjars/materialize/1.0.0-rc.2/dist/css/materialize.min.css">
<!-- Compiled and minified JavaScript -->
        <script src="webjars/materialize/1.0.0-rc.2/dist/js/materialize.min.js"></script>                

      
<!--        <link rel='stylesheet' href='webjars/bootstrap/4.1.2/css/bootstrap.min.css'>
        <script type='text/javascript' src='webjars/bootstrap/4.1.2/js/bootstrap.min.js'></script>        -->
    <script>
    $( function() {
      $( ".widget input[type=submit], .widget a, .widget button" ).button();
      $( "button, input, a" ).click( function( event ) {
        event.preventDefault();
      } );
    } );
    </script>
    </head>
    <body>
        <h1>Hello World! MVC DMP</h1>
        <br/>
        <a href="/pers" class="btn btn-warning">Ir Persona</a>
        
        <button class="ui-button ui-widget ui-corner-all">A button element</button>

        <input class="ui-button ui-widget ui-corner-all" type="submit" value="A submit button">

        <a class="ui-button ui-widget ui-corner-all" href="#">An anchor</a>  
        
  <button class="btn waves-effect waves-light" type="submit" name="action">Submit
    <i class="material-icons right">send</i>
  </button>        
        
    </body>
</html>
