<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src='/webjars/AdminLTE/2.4.2/bower_components/jquery/dist/jquery.min.js'></script>
<link rel="stylesheet" href="/resources/css/jquery.dataTables.min.css">

<div class="content-wrapper">
    <section class="content-header">
        
    </section>
    <section class="content">
        <div class="box">
          <div class="box-body">
            <form action="${pageContext.request.contextPath}/buscarSuc" method="POST">

            <div class="form-group">
                <label class="col-sm-2 control-label">Lugar</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control"  id="dato" name="dato"/>                     
                </div>                
                <div class="col-sm-1">
                    <input type="submit" value="Buscar" class="btn btn-primary"/>
                </div>
                <div class="col-sm-1">
                    <c:if test="$(ListaSucursal)">
                    <a class="btn btn-info" href="${pageContext.request.contextPath}/formSucursal">Nuevo</a>  
                    </c:if>
                </div>
            </div>
              </form>
          </div>
        </div>
        
        <c:if test="${!empty ListaSucursal}">
        <div class="box">
                <div class="box-header">
                    <h3 class="box-title">Reporte de Sucursales</h3>                                    
                </div><!-- /.box-header -->        
        <div class="box-body table-responsive">
        <table id="example1" class="table table-bordered table-striped">
          <thead >
            <tr>
              <th >Empresa</th>
              <th >Lugar</th>
              <th >Direccion</th>
              <th >Opciones</th>
            </tr>
          </thead>
          <tbody>
                <c:forEach items="${ListaSucursal}" var="dato">
                      <tr>
                        <td>${dato.idEmpresa.razonsocial}</td>
                        <td>${dato.lugar}</td>
                        <td>${dato.direccion}</td>
                        <td align="center">
                            <a href="${pageContext.request.contextPath}/elimSuc?id=${dato.idSucursal}" ><span title="Eliminar" class="glyphicon glyphicon-remove"></span></a>
                            <a href="${pageContext.request.contextPath}/formModif2Persona?id=${dato.idSucursal}" ><span title="Editar" class="glyphicon glyphicon-edit"></span></a>
                        
                        </td>
                      </tr>
              </c:forEach> 
            </tbody>
            <tfoot>
                <tr>
                <th >Empresa</th>
                <th >Lugar</th>
                <th >Direccion</th>
                <th >Opciones</th>
                </tr>
            </tfoot>            
          </table>  
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