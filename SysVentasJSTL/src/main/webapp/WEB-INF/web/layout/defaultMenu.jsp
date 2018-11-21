<%@page import="java.util.List"%>
<%@page import="pe.com.syscenterlife.modelo.SysAccesos"%>
<!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="${pageContext.request.contextPath}/resources/img/user2-160x160.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>Alexander Pierce</p>
          <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
      </div>
      <!-- search form -->
      <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="q" class="form-control" placeholder="Search...">
          <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
        </div>
      </form>
      <!-- /.search form -->
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu" data-widget="tree">
          <li class="header">MAIN NAVIGATION</li>
        <li class="active treeview">
          <a href="#">
            <i class="fa fa-dashboard"></i> <span>Dashboard</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          
 
        <li>
          <a href="pages/widgets.html">
            <i class="fa fa-th"></i> <span>Widgets</span>
            <span class="pull-right-container">
              <small class="label pull-right bg-green">new</small>
            </span>
          </a>
        </li>







        
<!--        Inicio -->
             <% List<SysAccesos> listAccess=null;
              listAccess=(List<SysAccesos>)session.getAttribute("ListaAccesosM");  
              int initGrupo=0;
              int initMenu=0;
              int initTodo=0;
              int inicio=0;
              SysAccesos[] dato=new SysAccesos[listAccess.size()];              
              for (SysAccesos acceso : listAccess) {
                    dato[inicio++]=acceso;
              }


              %> 
        <% if(listAccess!=null){ %>
        <% for (int i=0; i<dato.length; i++) { 
        initTodo++;
        %>
        
        <% if(initGrupo!=dato[i].getIdMenu().getIdGrupo().getIdGrupo()){  %>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-th"></i> <span><%=dato[i].getIdMenu().getIdGrupo().getNombre() %></span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
            <ul class="treeview-menu">
          <% initGrupo=dato[i].getIdMenu().getIdGrupo().getIdGrupo(); } %>
            
                <% if(initMenu!=dato[i].getIdMenu().getIdMenu()){ %>
                  <li class="treeview">
                    <a href="#"><i class="fa fa-laptop"></i><%=dato[i].getIdMenu().getNombre() %>
                      <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                      </span>
                    </a>
                      <ul class="treeview-menu">
                    <% } %>  
                            <% %>
                            <li><a href="${pageContext.request.contextPath}<%=dato[i].getUrl() %>"><i class="fa fa-edit"></i><%=dato[i].getNombre() %></a></li>                            
                            <% %>
                    <% if(initTodo<listAccess.size()){ %>       
                    <% if(dato[i].getIdMenu().getIdMenu()!=dato[i+1].getIdMenu().getIdMenu()){ %> 
                    </ul>
                  </li>                 
                    <%  } 
                        initMenu=dato[i].getIdMenu().getIdMenu();
                    }else{
                        %>
                    </ul>
                  </li>                         
                        <%
                       }
                    %>

                    
        <% if(initTodo<listAccess.size()){ %>
        <% if(dato[i].getIdMenu().getIdGrupo().getIdGrupo()!=dato[i+1].getIdMenu().getIdGrupo().getIdGrupo()){%>
            </ul>
        </li>
        <%  }  } else { %>
            </ul>
        </li>        
        
        <% } } %>
        <% } %>
        <!--        Fin -->
                
        <li class="header">LABELS</li>
        <li><a href="#"><i class="fa fa-circle-o text-red"></i> <span>Important</span></a></li>
        <li><a href="#"><i class="fa fa-circle-o text-yellow"></i> <span>Warning</span></a></li>
        <li><a href="#"><i class="fa fa-circle-o text-aqua"></i> <span>Information</span></a></li>
      </ul>
    </section>
    <!-- /.sidebar -->