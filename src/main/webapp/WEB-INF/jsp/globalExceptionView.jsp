<%@ include file="taglib.jsp"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="links.jsp"%>
<title><spring:message code="gev.title"/></title>
</head>
<body>
<nav class="navbar navbar-inverse">
<div class="container-fluid">
	<div class="navbar-header">
		<a class="navbar-brand" id="fonty" href="#"><spring:message code="gev.nav.link.hello"/>&nbsp;${pageContext.request.userPrincipal.name}</a>
	</div>
	<ul class="nav navbar-nav">
  <li>
    <a href="/"><spring:message code="gev.nav.link.home"/></a>
  </li>
  <li class="active">
    <a href="/welcome-person"><spring:message code="gev.nav.link.add"/></a>
  </li>
  <li>
    <a href="/list-person"><spring:message code="gev.nav.link.fetch"/></a>
  </li>
  <li>
    <a href="/logout"><spring:message code="gev.nav.link.logout"/></a>
  </li>
	</ul>	
</div>
</nav>
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<br/><br/><br/>
			<h1 class="onview">
				<spring:message code="gev.head"/>
			</h1>
			<br/>
			<h3 class="alert alert-danger"><spring:message code="gev.msg"/> :: ${exception.message}</h3>
			<br/>
		</div>
	</div> 
</div>
</body>
</html>