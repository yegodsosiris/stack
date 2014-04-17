 <header class="navbar navbar-static-top bs-docs-nav" id="top" role="banner">
  <div class="container">
    <div class="navbar-header">
      <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a href="${contextpath}" class="navbar-brand">The Stack</a>
    </div>
    <nav class="navbar-collapse bs-navbar-collapse collapse" role="navigation" style="height: 1px;">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Link</a></li>
        <li><a href="#">Link</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown"> MVC Examples <b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li><a href="${contextpath}/finance/records">All Records</a></li>
            <li><a href="${contextpath}/finance/newRecord">New Record</a></li>
            <li class="divider"></li>
            <li><a target="_blank" href="${contextpath}/rest/records/produce">All Records as a REST service</a></li>
            <li><a href="${contextpath}/rest/records/consume">Consume same REST service</a></li>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Non-functinal Example">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="${contextpath}/logout">Logout</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Admin Examples <b class="caret"></b></a>
          <ul class="dropdown-menu">
          <li><a href="${contextpath}/admin/users" >User Management</a></li>
		  <li><a href="${contextpath}/admin/settings">Settings</a></li>
		  <li><a href="${contextpath}/admin/logs" >Logs</a></li>
    
          </ul>
        </li>
    </nav>
  </div>
</header>