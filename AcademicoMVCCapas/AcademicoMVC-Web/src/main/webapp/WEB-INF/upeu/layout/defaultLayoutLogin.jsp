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
  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->    
  <!-- Google Font -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
  <link rel="stylesheet" type="text/css" href="/webjars/flag-icon-css/2.4.0/css/flag-icon.min.css" />          
</head>  
<body>
    
    
    <div class="container">
        <tiles:insertAttribute name="body" />
    </div> <!-- /container -->  
    
    
    <c:forEach var="script" items="${javascripts}">
        <script src='<c:url value="${script}"/>'></script>
    </c:forEach>            
</body>
</html>