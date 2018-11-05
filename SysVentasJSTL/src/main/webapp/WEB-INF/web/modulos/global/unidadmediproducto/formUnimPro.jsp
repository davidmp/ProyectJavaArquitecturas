<%-- 
    Document   : formUnimPro
    Created on : 31-oct-2018, 13:20:16
    Author     : quiroga
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
            <frm:form modelAttribute="modeloump" method="post" action="${urlsave}" class="form-horizontal" >

                <div class="box-body">
                    <div class="form-group">
                        <frm:hidden path="idUnidMedProducto" />
                        <frm:label path="cantidad" class="col-sm-2 control-label" >Cantidad:</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="cantidad" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="orden" class="col-sm-2 control-label" >Orden:</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="orden" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="unidadmin" class="col-sm-2 control-label" >Unidad Minima:</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="unidadmin" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">
                        <frm:label path="idProducto" class="col-sm-2 control-label">Producto:</frm:label>
                            <div class="col-sm-10">
                            <frm:select path="idProducto" class="form-control select2" style="width: 100%;">
                                <frm:options items="${ListaProducto}" itemLabel="nombre" itemValue="idProducto" />
                            </frm:select></div>
                    </div>
                    <div class="form-group">
                        <frm:label path="idUnidadMedida" class="col-sm-2 control-label">Unidad Medida:</frm:label>
                            <div class="col-sm-10">
                            <frm:select path="idUnidadMedida" class="form-control select2" style="width: 100%;">
                                <frm:options items="${ListarUnidadMedida}" itemLabel="nombre" itemValue="idUnidadMedida" />
                            </frm:select></div>
                    </div>


                </div>
                <!-- /.box-body -->

               
                    <div class="box-footer" style="margin-left: 80px">                
                        <input type="submit" value="Guardar" class="btn btn-primary" />
                
                    &nbsp;&nbsp;
                    <a href="${pageContext.request.contextPath}/prodMain" class="btn btn-primary">Cancelar</a> 
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

            var dato = $('#datepicker').val();
            var dato2 = dato.replace('-', '/')

            $('#datepicker').val(dato2.replace('-', '/'));
            //alert(dato2.replace('-','/'));
        });
    </script>     
</div> 
