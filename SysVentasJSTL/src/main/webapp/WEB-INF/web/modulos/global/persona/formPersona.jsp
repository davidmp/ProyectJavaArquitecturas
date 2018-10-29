<%-- 
    Document   : formPersona
    Created on : 03/10/2018, 11:47:27 AM
    Author     : LAB_SOFTWARE-DTI
--%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<script src='/webjars/AdminLTE/2.4.2/bower_components/jquery/dist/jquery.min.js'></script>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
<!-- Main content -->
<section class="content">    
    <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Formulario de Registro</h3>
            </div>
    <c:url var="urlsave" value="${pageContext.request.contextPath}/${urlAccion}" />
    <frm:form modelAttribute="modeloPersona" method="post" action="${urlsave}" class="form-horizontal" >
  
            <div class="box-body">
                <div class="form-group">
                    <frm:hidden path="idPersona" />
                    <frm:label path="nombre" class="col-sm-2 control-label" >Primer Nombre:</frm:label>
                    <div class="col-sm-10">
                    <frm:input path="nombre" class="form-control" />
                    </div>
                </div>
                <div class="form-group">                    
                    <frm:label path="nombre2" class="col-sm-2 control-label" >Segundo Nombre:</frm:label>
                    <div class="col-sm-10">
                    <frm:input path="nombre2" class="form-control" />
                    </div>
                </div>
                <div class="form-group">
                    <frm:label path="apellPaterno" class="col-sm-2 control-label">Apell. Paterno:</frm:label>
                    <div class="col-sm-10"><frm:input path="apellPaterno" class="form-control"  /></div>                    
                </div>
                <div class="form-group">
                    <frm:label path="apellMaterno" class="col-sm-2 control-label">Apell. Materno:</frm:label>
                    <div class="col-sm-10"><frm:input path="apellMaterno" class="form-control"  /></div>                    
                </div>
                <div class="form-group">
                    <frm:label path="dni" class="col-sm-2 control-label">DNI:</frm:label>
                    <div class="col-sm-10"><frm:input path="dni" class="form-control" /></div>
                </div>
                <div class="form-group ">
                    <frm:label path="fechaNacimiento" class="col-sm-2 control-label">F.Nacimiento:</frm:label>
                    <div class="col-sm-10" >
                    <frm:input path="fechaNacimiento"  class="form-control" id="datepicker" placeholder="yyyy/mm/dd" />
                    </div>
                </div>
                   
                <div class="form-group" >
                    <frm:label path="sexo" class="col-sm-2 control-label">Sexo:</frm:label>
                    <div class="col-sm-10">
                    <frm:select path="sexo" class="form-control select2" style="width: 100%;">
                        <frm:options items="${ListGenero}" />
                    </frm:select></div>
                </div>
                <div class="form-group" >
                    <frm:label path="celular" class="col-sm-2 control-label">Celular:</frm:label>
                    <div class="col-sm-10"><frm:input path="celular" class="form-control" /></div>
                </div>
                <div class="form-group" >
                    <frm:label path="direccion" class="col-sm-2 control-label">Dirección:</frm:label>
                    <div class="col-sm-10"><frm:input path="direccion" class="form-control" /></div>
                </div>
                <div class="form-group" >
                    <frm:label path="idioma" class="col-sm-2 control-label">Idioma:</frm:label>
                    <div class="col-sm-10">
                    <frm:select path="idioma" class="form-control select2" style="width: 100%;">
                        <frm:options items="${ListIdioma}" />
                    </frm:select></div>
                </div>
                <div class="form-group" >
                  <frm:label path="email" class="col-sm-2 control-label">Email address</frm:label>
                  <div class="col-sm-10"><frm:input path="email" class="form-control" id="email" placeholder="Enter email" /></div>
                </div>
                <div class="form-group" >
                    <frm:label path="usuario" class="col-sm-2 control-label">Usuario:</frm:label>
                    <div class="col-sm-10"><frm:input path="usuario" class="form-control" /></div>
                </div>
                <div class="form-group" >
                    <frm:label path="clave" class="col-sm-2 control-label">Password:</frm:label>
                    <div class="col-sm-10"><frm:password path="clave" class="form-control" /></div>
                </div>
              </div>
              <!-- /.box-body -->

                        
              <div class="box-footer" style="margin-left: 80px">                
                  <input type="submit" value="Guardar" class="btn btn-primary" />
                  
                  &nbsp;&nbsp;
                  <a href="${pageContext.request.contextPath}/perMain" class="btn btn-primary">Cancelar</a> 
              </div>            
    </frm:form>
</div>

</section> 
<script type="text/javascript">
    $(function () {
       //$('#datetimepicker1').datetimepicker();
    $('#datepicker').datepicker({        
        //format: 'dd-MMM-yyyy'
        format: 'yyyy/mm/dd'
    }); 

        var dato=$('#datepicker').val();
        var dato2=dato.replace('-','/')
        
        $('#datepicker').val(dato2.replace('-','/'));
        //alert(dato2.replace('-','/'));
    });
</script>     
</div> 
  