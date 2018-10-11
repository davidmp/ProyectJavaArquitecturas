<%-- 
    Document   : formPersona
    Created on : 03/10/2018, 11:47:27 AM
    Author     : LAB_SOFTWARE-DTI
--%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
<!-- Main content -->
<section class="content">    
<div class="card">

<div class="card-body">
    <c:url var="urlsave" value="${pageContext.request.contextPath}/guardarPersona" />
    <frm:form modelAttribute="modeloPersona" method="post" action="${urlsave}">
        <table>
            <tr>
                <td><frm:label path="nombre">Nombres:</frm:label> </td>
                <td><frm:input path="nombre" class="form-control" size="60" /></td>
            </tr>
            <tr>
                <td><frm:label path="apellidos">Apellidos:</frm:label> </td>
                <td><frm:input path="apellidos" class="form-control"  /></td>
            </tr>
            <tr>
                <td><frm:label path="dni">DNI:</frm:label> </td>
                <td><frm:input path="dni" class="form-control" /></td>
            </tr>
            <tr>
                <td><frm:label path="telefono">Telefono:</frm:label> </td>
                <td><frm:input path="telefono" class="form-control" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Guardar" class="btn btn-primary" /></td>
            </tr>
        </table>
    </frm:form>
</div>
</div>
</section>        
</div>    