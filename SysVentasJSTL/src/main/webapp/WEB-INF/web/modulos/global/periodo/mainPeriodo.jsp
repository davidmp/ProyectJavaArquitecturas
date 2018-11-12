<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src='/webjars/AdminLTE/2.4.2/bower_components/jquery/dist/jquery.min.js'></script>
<link rel="stylesheet" href="/resources/css/jquery.dataTables.min.css">
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
  <!-- Content Header (Page header) -->
  <section class="content-header">
    <h1>
      Page Header
      <small>Optional description</small>
    </h1>
    <ol class="breadcrumb">
      <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
      <li class="active">Here</li>
      <li class="active"><a href="/pers" class="btn btn-warning">Ir Persona</a></li>
    </ol>
  </section>

  <!-- Main content -->
  <section class="content">

    <!-- Your Page Content Here -->

    Idioma: <a href="?lang=en">Ingles</a> | <a href="?lang=fr">Frances</a> | <a href="?lang=es">Español</a><br/> 
    Mensaje: 
    ${message} <br/>               
    <p> <spring:message code="welcome.greeting" arguments="${startMeeting}" /> </p> 
    <br/>
          <div class="box">
          <div class="box-body">
            <form action="${pageContext.request.contextPath}/buscarPeriodo" method="POST">

            <div class="form-group">
                <label class="col-sm-1 control-label">Periodo:</label>
                <div class="col-sm-2">                    
                    <input type="text" class="form-control"  id="dato" name="dato"/> 
                </div>                
                <div class="col-sm-1">Monto:                                      
                <input type="text" class="form-control" id="monto" name="monto" />                    
                </div>                
                <div class="col-sm-1">Pre. Unit:                                      
                    <input type="text" class="form-control" id="punit" name="punit" onkeyup="operar()" />                    
                </div>                
                <div class="col-sm-1">Cantidad:                                      
                <input type="text" class="form-control" id="cantidad" name="cantidad" onkeyup="operar()" />                    
                </div>                
                <div class="col-sm-1">IGV:                                      
                <input type="text" class="form-control" id="igv" name="igv"  />                    
                </div>                
                <div class="col-sm-1">Total:                                      
                <input type="text" class="form-control" id="total" name="total" />                    
                </div>                
                <div class="col-sm-1">
                    <input type="submit" value="Buscar" class="btn btn-primary"/>
                </div>
                <div class="col-sm-1">
                    <a class="btn btn-info" href="${pageContext.request.contextPath}/formPersona">Nuevo</a>  
                </div>
            </div>
              </form>
          </div>
          </div>        
    <c:if test="${!empty ListaPeriodo}">
        <div class="box">
                <div class="box-header">
                    <h3 class="box-title">Reporte de Periodos</h3>                                    
                </div><!-- /.box-header -->        
        <div class="box-body table-responsive">
        <table id="example1" class="table table-bordered table-striped">
          <thead >
            <tr>
              <th >#</th>
              <th >Periodo</th>
              <th >Fecha Inicio</th>
              <th >Fecha Fin</th>
              <th >Opciones</th>
            </tr>
          </thead>
          <tbody>
                <c:forEach items="${ListaPeriodo}" var="dato">
                      <tr>
                        <th >1</th>
                        <td>${dato.periodo}</td>
                        <td>${dato.fechaInicio}</td>
                        <td>${dato.fechaFin}</td>
                        <td align="center">
                            <a href="${pageContext.request.contextPath}/elimPeriodo?id=${dato.idPeriodo}" ><span title="Eliminar" class="glyphicon glyphicon-remove"></span></a>
                            <a href="${pageContext.request.contextPath}/formModif2Periodo?id=${dato.idPeriodo}" ><span title="Editar" class="glyphicon glyphicon-edit"></span></a>
                        
                        </td>
                      </tr>
              </c:forEach> 
            </tbody>
            <tfoot>
                <tr>
                <th >#</th>
                <th >Periodo</th>
                <th >Fecha Inicio</th>
                <th >Fecha Fin</th>
                <th >Opciones</th>
                </tr>
            </tfoot>            
          </table>  
          </div>
        </div>                                
          </c:if>                   
  </section><!-- /.content -->  

</div><!-- /.content-wrapper -->
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
    $('#punit').val(0);
    $('#cantidad').val(1);
    $('#total').val($('#punit').val()*$('#cantidad').val());
    $('#total').prop('readonly', true);
    $('#igv').val(0);
  });
  
  function operar(){
      var dato=$('#punit').val()*$('#cantidad').val();
      
      $('#total').val(dato);
      //var igvx=(($('#total').val()*18)/118); //+(Math.round((($('#total').val()*18)/118) + "e+2")  + "e-2")
      var igvx=+(Math.round((($('#total').val()*18)/118) + "e+2")  + "e-2"); //+(Math.round((($('#total').val()*18)/118) + "e+2")  + "e-2")
      $('#igv').val(igvx);
  }
</script>