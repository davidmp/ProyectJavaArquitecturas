<%-- 
    Document   : formPersona
    Created on : 03/10/2018, 11:47:27 AM
    Author     : LAB_SOFTWARE-DTI
--%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<br/>
<div class="card">
<div class="card-body">
    <c:url var="urlsave" value="${pageContext.request.contextPath}/guardarPersona" />
    <frm:form modelAttribute="modeloPersona" method="post" action="${urlsave}">
        Holas
    </frm:form>
</div>
</div>