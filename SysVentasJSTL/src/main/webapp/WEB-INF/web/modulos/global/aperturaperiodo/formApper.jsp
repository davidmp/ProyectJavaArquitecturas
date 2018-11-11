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
    <c:url var="urlsave" value="${pageContext.request.contextPath}/guardarApper" />
    <c:if test="${(!empty ListAlmacen) and (!empty ListConfiguracion) and (!empty ListPeriodo)}">
    <frm:form modelAttribute="modeloApper" method="post" action="${urlsave}" class="form-horizontal" >
            
            <div class="box-body">
                <div class="form-group">
                    <frm:hidden path="idAperturaPeriodo" />
                    <frm:label path="estado" class="col-sm-2 control-label" >Estado:</frm:label>
                    <div class="col-sm-10">
                    <frm:input path="estado" class="form-control" />
                    </div>
                </div>
                <div class="form-group">                    
                    <frm:label path="ip" class="col-sm-2 control-label" >Ip:</frm:label>
                    <div class="col-sm-10">
                    <frm:input path="ip" class="form-control" />
                    </div>
                </div>
                <div class="form-group">
                    <frm:label path="idTrabajador" class="col-sm-2 control-label">Trabajador</frm:label>
                    <div class="col-sm-10">
                    <frm:select path="idTrabajador" class="form-control select2" style="width: 100%;">
                        <frm:option value="1">Jorge</frm:option>
                        <frm:option value="2">Carlos</frm:option>
                        <frm:option value="3">Jessica</frm:option>
                    </frm:select></div>  
                </div>
                <div class="form-group" >
                    <frm:label path="idAlmacen.idAlmacen" class="col-sm-2 control-label">Almacen:</frm:label>
                    <div class="col-sm-10">
                    <frm:select path="idAlmacen.idAlmacen" class="form-control select2" style="width: 100%;">
                        <frm:options items="${ListAlmacen}" itemLabel="nombreAlmacen" itemValue="idAlmacen" />
                    </frm:select></div>
                </div>
                <div class="form-group" >
                    <frm:label path="idConfiguracion.idConfiguracion" class="col-sm-2 control-label">Configuracion:</frm:label>
                    <div class="col-sm-10">
                    <frm:select path="idConfiguracion.idConfiguracion" class="form-control select2" style="width: 100%;">
                        <frm:options items="${ListConfiguracion}" itemLabel="igvPorcent" itemValue="idConfiguracion" />
                    </frm:select></div>
                </div>
                <div class="form-group">
                    <frm:label path="idPeriodo.idPeriodo" class="col-sm-2 control-label">Periodo:</frm:label>
                    <div class="col-sm-10">
                    <frm:select path="idPeriodo.idPeriodo" class="form-control select2" style="width: 100%;">
                        <frm:options items="${ListPeriodo}" itemLabel="periodo" itemValue="idPeriodo" />
                    </frm:select></div>
                </div>
              </div>
              <!-- /.box-body -->

                        
              <div class="box-footer" style="margin-left: 80px">                
                  <input type="submit" value="Guardar" class="btn btn-primary" />
                  
                  &nbsp;&nbsp;
                  <a href="${pageContext.request.contextPath}/ApperMain" class="btn btn-primary">Cancelar</a> 
              </div>            
    </frm:form>        
    </c:if>   
    <c:if test="${(empty ListAlmacen) or (empty ListConfiguracion) or (empty ListPeriodo)}">
        Debes tener por lo menos un registro en las tablas Almacen, Configuracion y Periodo para poder registrar.
    </c:if>
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
  