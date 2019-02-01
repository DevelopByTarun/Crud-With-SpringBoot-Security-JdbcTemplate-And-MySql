<%@ include file="taglib.jsp"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="links.jsp"%>
<title><spring:message code="ad.title"/></title>
</head>
<body>
<nav class="navbar navbar-inverse">
<div class="container-fluid">
	<div class="navbar-header">
		<a class="navbar-brand" id="fonty" href="#"><spring:message code="ad.nav.link.hello"/>&nbsp;${pageContext.request.userPrincipal.name}</a>
	</div>
	<ul class="nav navbar-nav">
  <li>
    <a href="/"><spring:message code="ad.nav.link.home"/></a>
  </li>
  <li>
    <a href="/welcome-person"><spring:message code="ad.nav.link.add"/></a>
  </li>
  <li>
    <a href="/list-person"><spring:message code="ad.nav.link.fetch"/></a>
  </li>
  <li class="active">
    <a href="/logout"><spring:message code="ad.nav.link.logout"/></a>
  </li>
	</ul>
	<ul class="nav navbar-nav navbar-right">
		<li>
			<a href="/accessdenied-person?language=en"><span class="glyphicon glyphicon-user"></span> English</a>
		</li>
      <li>
      	<a href="/accessdenied-person?language=hi"><span class="glyphicon glyphicon-log-in"></span> Hindi</a>
      	</li>
	</ul>
</div>
</nav>
<div class="container">
	<div class="row">
		<div class="col-md-12">
		<br/><br/><br/>
			<h1 id="banner"><spring:message code="ad.head"/></h1>
		<hr />
		<c:if test="${not empty error}">
			<div style="color:red">
				<h3>
				<spring:message code="ad.h3"/><br /> 
				<spring:message code="ad.h3.2"/> : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
				</h3>
			</div>
		</c:if>
		<br/>
		<h4 class="message"><spring:message code="ad.h4"/></h4>
		</div>
	</div>
</div>
</body>
</html>