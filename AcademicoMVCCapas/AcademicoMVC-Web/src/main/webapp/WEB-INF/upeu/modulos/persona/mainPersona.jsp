<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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
                <p:editor/>
                 Idioma: <a href="?lang=en">Ingles</a> | <a href="?lang=fr">Frances</a> | <a href="?lang=es">Español</a><br/> 
                Mensaje: 
                ${message} <br/>               
                <p> <spring:message code="welcome.greeting" arguments="${startMeeting}" /> </p> 
                <br/>
                <form action="${pageContext.request.contextPath}/buscar" method="POST">
                      <div class="card">
                      <div class="card-body">
                          <table>
                              <tr>
                                  <td>Nombre:</td>
                                  <td> <input type="text" class="form-control"  id="dato" name="dato"/></td>
                                  <td><input type="submit" value="Buscar" class="btn btn-primary"/>  </td>                                                
                                  <td><a class="btn btn-info" href="${pageContext.request.contextPath}/formPersona">Nuevo</a>  </td>                                                
                              </tr>
                          </table> 
                      </div>
                      </div>       
                  </form>
                  <br/>
<c:if test="${!empty ListaPersona}">
                    <table class="table">
                      <thead class="thead-dark">
                        <tr>
                          <th scope="col">#</th>
                          <th scope="col">Nombre</th>
                          <th scope="col">Apellidos</th>
                          <th scope="col">DNI</th>
                          <th scope="col">Opciones</th>
                        </tr>
                      </thead>
                      <tbody>
                            <c:forEach items="${ListaPersona}" var="dato">
                                  <tr>
                                    <th scope="row">1</th>
                                    <td>${dato.nombre}</td>
                                    <td>${dato.apellidos}</td>
                                    <td>${dato.dni}</td>
                                    <td><a href="${pageContext.request.contextPath}/elim?id=${dato.idPersona}">E</a></td>
                                  </tr>
                          </c:forEach> 
                        </tbody>
                      </table>   
                      </c:if>                   
              </section><!-- /.content -->

            </div><!-- /.content-wrapper -->

