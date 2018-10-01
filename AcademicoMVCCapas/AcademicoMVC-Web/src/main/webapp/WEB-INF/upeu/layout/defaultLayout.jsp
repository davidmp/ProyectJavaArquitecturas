<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> 
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html> 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title><tiles:getAsString name="title" /></title>
        <link rel='stylesheet' href='webjars/bootstrap/4.1.2/css/bootstrap.min.css'>
        <script type='text/javascript' src='webjars/bootstrap/4.1.2/js/bootstrap.min.js'></script>
        
        <link rel="stylesheet" href="resources/jquery/jquery-ui.css">        
        <script type='text/javascript' src='webjars/jquery/3.3.1/dist/jquery.min.js'></script>   
        <link href="resources/style/app.css" rel="stylesheet">
</head>  
<body>
        <header id="header">
            <tiles:insertAttribute name="header" />
        </header>
     
        <section id="sidemenu">
            <tiles:insertAttribute name="menu" />
        </section>
             
        <section id="site-content">
            <tiles:insertAttribute name="body" />
        </section>
         
        <footer id="footer">
            <tiles:insertAttribute name="footer" />
        </footer>
</body>
</html>