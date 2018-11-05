<%-- 
    Document   : mainProducto
    Created on : 31-oct-2018, 7:04:32
    Author     : quiroga
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<link rel="stylesheet" href="/resources/css/jquery.dataTables.min.css">
<div class="content-wrapper">
    <section class="content-header">

    </section>    
    <section class="content">
        Idioma: <a href="?lang=en">Ingles</a> | <a href="?lang=fr">Frances</a> | <a href="?lang=es">Español</a><br/> 
        Mensaje: 
        ${message} <br/>               
        <p> <spring:message code="welcome.greeting" arguments="${startMeeting}" /> </p> 
        <br/>
        <div class="box">
            <div class="box-body">
                <form action="${pageContext.request.contextPath}/buscarump" method="POST">

                    <div class="form-group">
                        <label class="col-sm-2 control-label">UnidadMinima:</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control"  id="dato" name="dato"/>                     
                        </div>                
                        <div class="col-sm-1">
                            <input type="submit" value="Buscar" class="btn btn-primary"/>
                        </div>
                        <div class="col-sm-1">
                            <a class="btn btn-info" href="${pageContext.request.contextPath}/formump">Nuevo</a>  
                        </div>
                    </div>
                </form>
            </div>
        </div>        
        <c:if test="${!empty ListaUniMediProducto}">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">Reporte de Personas</h3>                                    
                </div><!-- /.box-header -->        
                <div class="box-body table-responsive">
                    <table id="example1" class="table table-bordered table-striped">
                        <thead >
                            <tr>
                                <th >#</th>
                                <th >Cantidad</th>
                                <th >Orden</th>
                                <th >UNi min</th>
                                <th >Opciones</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${ListaUniMediProducto}" var="dato">
                            <tr>
                                <th >1</th>
                                <td>${dato.cantidad}</td>
                                <td>${dato.orden}</td>
                                <td>${dato.unidadmin}</td>
                                <td align="center">
                                    <a href="${pageContext.request.contextPath}/elimump?id=${dato.idUnidMedProducto}" ><span title="Eliminar" class="glyphicon glyphicon-remove"></span></a>
                                    <a href="${pageContext.request.contextPath}/formModifump?id=${dato.idUnidMedProducto}" ><span title="Editar" class="glyphicon glyphicon-edit"></span></a>

                                </td>
                            </tr>
                        </c:forEach> 
                        </tbody>
                        <tfoot>
                            <tr>
                                <th >#</th>
                                <th >Cantidad</th>
                                <th >Orden</th>
                                <th >UNi min</th>
                                <th >Opciones</th>
                            </tr>
                        </tfoot>            
                    </table>  
                </div>
            </div>                                
        </c:if>    
    </section>

</div>
<script>
    $(function () {
        $('#example1').DataTable();
//    $('#example2').DataTable({
//      'paging'      : true,
//      'lengthChange': true,
//      'searching'   : true,
//      'ordering'    : true,
//      'info'        : true,
//      'autoWidth'   : false
//    });
    });
</script>