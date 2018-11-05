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
              <h3 class="box-title">Formulario de Manufactura</h3>
            </div>
    <c:url var="urlsave" value="${pageContext.request.contextPath}/${urlAccion}" />
    <frm:form modelAttribute="modeloManufactura" method="post" action="${urlsave}" class="form-horizontal" >
  
            <div class="box-body">
                <div class="form-group">
                    <frm:hidden path="idManufactura" />
                  
                </div>
                
                <div class="form-group">
                    <frm:label path="idTipomanufact" class="col-sm-2 control-label">Tipo manufactura:</frm:label>
                    <div class="col-sm-10"><frm:input path="idTipomanufact" class="form-control"  /></div>                    
                </div>
                
                <div class="form-group">
                    <frm:label path="idCategoriamanufactura" class="col-sm-2 control-label">Categoria:</frm:label>
                    <div class="col-sm-10"><frm:input path="idCategoriamanufactura" class="form-control" /></div>
                </div>
                <div class="form-group">
                 
                    <frm:label path="nombre" class="col-sm-2 control-label" >Nombre:</frm:label>
                    <div class="col-sm-10"><frm:input path="nombre" class="form-control" /></div>
                </div>
                <div class="form-group ">
                    <frm:label path="estado" class="col-sm-2 control-label">Estado:</frm:label>
                    <div class="col-sm-10" ><frm:input path="estado"  class="form-control" /></div>
                </div>
                <div class="form-group ">
                    <frm:label path="descripcion" class="col-sm-2 control-label">Descripcion:</frm:label>
                    <div class="col-sm-10" ><frm:input path="descripcion"  class="form-control" /></div>
                </div>  
                
               
              </div>
              <!-- /.box-body -->

                        
              <div class="box-footer" style="margin-left: 80px">                
                  <input type="submit" value="guardar" class="btn btn-primary" />
                  
                  &nbsp;&nbsp;
                  <a href="${pageContext.request.contextPath}/manuMain" class="btn btn-primary">Cancelar</a> 
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
  