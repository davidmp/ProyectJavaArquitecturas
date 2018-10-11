<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html> 
<head>
  <meta charset="utf-8"> 
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title><tiles:getAsString name="title" /></title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

    <tilesx:useAttribute id="stylesheets" name="stylesheets" classname="java.util.List" />
    <tilesx:useAttribute id="javascripts" name="javascripts" classname="java.util.List" />	
    <c:forEach var="css" items="${stylesheets}">
    <link rel='stylesheet' type='text/css' href='<c:url value="${css}"/>'>
    </c:forEach> 
  <!-- Google Font -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
          
</head>  
<body class="hold-transition skin-blue sidebar-mini">
    
    <div class="wrapper">
        <header id="header" class="main-header">
            <tiles:insertAttribute name="header" />
        </header>
     
        <section id="sidemenu" class="main-sidebar">
            <tiles:insertAttribute name="menu" />
        </section>
             
        <section id="site-content" >
            <tiles:insertAttribute name="body" />
        </section>
         
        <footer id="footer" class="main-footer">
            <tiles:insertAttribute name="footer" />
        </footer>
         
        </div>
    <c:forEach var="script" items="${javascripts}">
        <script src='<c:url value="${script}"/>'></script>
    </c:forEach>            
</body>
</html>