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
    <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Formulario de Registro</h3>
            </div>
    <c:url var="urlsave" value="${pageContext.request.contextPath}/guardarPersona" />
    <frm:form modelAttribute="modeloPersona" method="post" action="${urlsave}" class="form-horizontal" >
  
            <div class="box-body">
                <div class="form-group">
                    <frm:label path="nombre" class="col-sm-2 control-label" >Nombres:</frm:label>
                    <div class="col-sm-10">
                    <frm:input path="nombre" class="form-control" />
                    </div>
                </div>
                <div class="form-group">
                    <frm:label path="apellidos" class="col-sm-2 control-label">Apellidos:</frm:label>
                    <div class="col-sm-10"><frm:input path="apellidos" class="form-control"  /></div>                    
                </div>
                <div class="form-group">
                    <frm:label path="dni" class="col-sm-2 control-label">DNI:</frm:label>
                    <div class="col-sm-10"><frm:input path="dni" class="form-control" /></div>
                </div>
                <div class="form-group" >
                    <frm:label path="telefono" class="col-sm-2 control-label">Telefono:</frm:label>
                    <div class="col-sm-10"><frm:input path="telefono" class="form-control" /></div>
                </div>

                <div class="form-group" >
                  <label for="exampleInputEmail1" class="col-sm-2 control-label">Email address</label>
                  <div class="col-sm-10"><input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email"></div>
                </div>

              </div>
              <!-- /.box-body -->

              <div class="box-footer">                
                <input type="submit" value="Guardar" class="btn btn-primary pull-right" />
              </div>            
    </frm:form>
</div>

</section>        
</div>    