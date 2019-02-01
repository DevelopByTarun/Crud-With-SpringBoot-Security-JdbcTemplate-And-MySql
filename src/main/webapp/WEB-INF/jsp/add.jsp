<%@ include file="taglib.jsp"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="links.jsp"%>
<title><spring:message code="add.title"/></title>
</head>
<body>
<nav class="navbar navbar-inverse">
<div class="container-fluid">
	<div class="navbar-header">
		<a class="navbar-brand" id="fonty" href="#"><spring:message code="add.nav.link.hello"/>&nbsp;${pageContext.request.userPrincipal.name}</a>
	</div>
	<ul class="nav navbar-nav">
  <li>
    <a href="/"><spring:message code="add.nav.link.home"/></a>
  </li>
  <li class="active">
    <a href="/welcome-person"><spring:message code="add.nav.link.add"/></a>
  </li>
  <li>
    <a href="/list-person"><spring:message code="add.nav.link.fetch"/></a>
  </li>
  <li>
    <a href="/logout"><spring:message code="add.nav.link.logout"/></a>
  </li>
	</ul>
	<ul class="nav navbar-nav navbar-right">
		<li>
			<a href="/welcome-person?language=en"><span class="glyphicon glyphicon-user"></span> English</a>
		</li>
      <li>
      	<a href="/welcome-person?language=hi"><span class="glyphicon glyphicon-log-in"></span> Hindi</a>
      	</li>
	</ul>
</div>
</nav>
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<br/><br/>
			<h1 class="idx"><spring:message code="add.head"/></h1>
<br/>
<form action="/add-person" method="post">
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label"><strong><spring:message code="add.form.id"/>&nbsp;::</strong></label>
    <div class="col-sm-10">
      <input type="text" name="id" class="form-control" id="inputEmail3" placeholder="Enter Person Id">
    </div>
  </div>
  
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label"><strong><spring:message code="add.form.fname"/>&nbsp;::</strong></label>
    <div class="col-sm-10">
      <input type="text" name="firstName" class="form-control" id="inputEmail3" placeholder="Enter Person FirstName">
    </div>
  </div>
  
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label"><strong><spring:message code="add.form.lname"/>&nbsp;::</strong></label>
    <div class="col-sm-10">
      <input type="text" name="lastName" class="form-control" id="inputEmail3" placeholder="Enter Person LastName">
    </div>
  </div>
  
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label"><strong><spring:message code="add.form.age"/>&nbsp;::</strong></label>
    <div class="col-sm-10">
      <input type="text" name="age" class="form-control" id="inputEmail3" placeholder="Enter Person Age">
    </div>
  </div>
  
  <div class="form-group row">
    <label for="inputPassword3" class="col-sm-2 col-form-label"><strong><spring:message code="add.form.city"/>&nbsp;::</strong></label>
    <div class="col-sm-10">
      <input type="text" name="city" class="form-control" id="inputPassword3" placeholder="Enter Person City">
    </div>
  </div>
  
  <div class="form-group row">
  	<label for="inputPassword3" class="col-sm-2 col-form-label"></label>
    <div class="col-sm-10">
      <button type="submit" class="btn btn-primary btn3d btn-lg"><span class="glyphicon glyphicon-cloud"></span> <spring:message code="add.form.button"/></button>
    </div>
  </div>
</form>
		</div>
	</div>
</div>
</body>
</html>