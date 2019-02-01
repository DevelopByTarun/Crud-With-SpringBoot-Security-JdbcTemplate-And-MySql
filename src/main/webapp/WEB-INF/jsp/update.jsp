<%@ include file="taglib.jsp"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="links.jsp"%>
<title><spring:message code="update.title"/></title>
</head>
<body>
<nav class="navbar navbar-inverse">
<div class="container-fluid">
	<div class="navbar-header">
		<a class="navbar-brand" id="fonty" href="#"><spring:message code="update.nav.link.hello"/>&nbsp;${pageContext.request.userPrincipal.name}</a>
	</div>
	<ul class="nav navbar-nav">
  <li>
    <a href="/"><spring:message code="update.nav.link.home"/></a>
  </li>
  <li>
    <a href="/welcome-person"><spring:message code="update.nav.link.add"/></a>
  </li>
  <li class="active">
    <a href="/list-person"><spring:message code="update.nav.link.fetch"/></a>
  </li>
  <li>
    <a href="/logout"><spring:message code="update.nav.link.logout"/></a>
  </li>
	</ul>
</div>
</nav>
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<br/><br/>
			<h1 class="enter"><spring:message code="update.head"/></h1>
<br/>
<form action="/update-person" method="post">
  
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label"><strong><spring:message code="update.form.id"/>&nbsp;::</strong></label>
    <div class="col-sm-10">
      <input type="text" name="id" value="<%= ((Person)request.getAttribute("values")).getId() %>" class="form-control is-valid" id="inputEmail3" readonly>
    </div>
  </div>
    
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label"><strong><spring:message code="update.form.fname"/>&nbsp;::</strong></label>
    <div class="col-sm-10">
      <input type="text" name="firstName" value="<%= ((Person)request.getAttribute("values")).getFirstName() %>" class="form-control is-valid" id="inputEmail3">
    </div>
  </div>
  
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label"><strong><spring:message code="update.form.lname"/>&nbsp;::</strong></label>
    <div class="col-sm-10">
      <input type="text" name="lastName" value="<%= ((Person)request.getAttribute("values")).getLastName() %>" class="form-control is-valid" id="inputEmail3">
    </div>
  </div>
  
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label"><strong><spring:message code="update.form.age"/>&nbsp;::</strong></label>
    <div class="col-sm-10">
      <input type="text" name="age" value="<%= ((Person)request.getAttribute("values")).getAge() %>" class="form-control is-valid" id="inputEmail3">
    </div>
  </div>
  
  <div class="form-group row">
    <label for="inputPassword3" class="col-sm-2 col-form-label"><strong><spring:message code="update.form.city"/>&nbsp;::</strong></label>
    <div class="col-sm-10">
      <input type="text" name="city" value="<%= ((Person)request.getAttribute("values")).getCity() %>" class="form-control is-valid" id="inputPassword3">
    </div>
  </div>
  
  <div class="form-group row">
  	<label for="inputPassword3" class="col-sm-2 col-form-label"></label>
    <div class="col-sm-10">
      <button type="submit" class="btn btn-info btn3d btn-lg"><span class="glyphicon glyphicon-question-sign"></span> <spring:message code="update.form.button"/></button>
    </div>
  </div>
</form>
		</div>
	</div>
</div>
</body>
</html>