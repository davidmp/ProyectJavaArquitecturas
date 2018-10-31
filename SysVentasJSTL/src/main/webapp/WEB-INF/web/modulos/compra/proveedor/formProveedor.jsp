<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<script src='/webjars/AdminLTE/2.4.2/bower_components/jquery/dist/jquery.min.js'></script>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <section class="content-header">

    </section>    
    <section class="content">

<div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Formulario de Proveedor</h3>
            </div>
    <c:url var="urlsave" value="${pageContext.request.contextPath}/${urlAccion}" />
    <frm:form modelAttribute="modeloProveedor" method="post" action="${urlsave}" class="form-horizontal" >
  
            <div class="box-body">
                
                   
                <div class="form-group" >
                    <frm:label path="idPersona" class="col-sm-2 control-label">Sexo:</frm:label>
                    <div class="col-sm-10">
                    <frm:select path="idPersona" class="form-control select2" style="width: 100%;">
                        <frm:options items="${ListPersonas}" itemLabel="nombre" itemValue="idPersona" />
                    </frm:select></div>
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

</div>