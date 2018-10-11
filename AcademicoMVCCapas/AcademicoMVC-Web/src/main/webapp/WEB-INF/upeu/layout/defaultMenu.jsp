<aside class="main-sidebar">
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
          <ul class="treeview-menu">
                    <li class="active"><a href="${pageContext.request.contextPath}/"><i class="fa fa-circle-o"></i> Home</a></li>
                    <li ><a href="${pageContext.request.contextPath}/products"><i class="fa fa-circle-o"></i> Products</a></li>
                    <li ><a href="${pageContext.request.contextPath}/contactus"><i class="fa fa-circle-o"></i> Contact Us</a></li>
                    <li ><a href="${pageContext.request.contextPath}/pru1"><i class="fa fa-circle-o"></i> Prueba1</a></li>
                    <li ><a href="${pageContext.request.contextPath}/pru2"><i class="fa fa-circle-o"></i> Prueba2</a></li>
                    <li ><a href="${pageContext.request.contextPath}/pers"><i class="fa fa-circle-o"></i> Persona Main</a></li>
                    <li ><a href="${pageContext.request.contextPath}/report"><i class="fa fa-circle-o"></i> Persona Reporte</a></li>   
          </ul>
        </li>
        
        <li><a href="https://adminlte.io/docs"><i class="fa fa-book"></i> <span>Documentation</span></a></li>
        <li class="header">LABELS</li>
        <li><a href="#"><i class="fa fa-circle-o text-red"></i> <span>Important</span></a></li>
        <li><a href="#"><i class="fa fa-circle-o text-yellow"></i> <span>Warning</span></a></li>
        <li><a href="#"><i class="fa fa-circle-o text-aqua"></i> <span>Information</span></a></li>
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>