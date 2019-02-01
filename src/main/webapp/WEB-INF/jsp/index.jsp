<%@ include file="taglib.jsp"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="links.jsp"%>
<title><spring:message code="index.title"/></title>
</head>
<body>
<nav class="navbar navbar-inverse">
<div class="container-fluid">
	<div class="navbar-header">
		<a class="navbar-brand" id="fonty" href="#"><spring:message code="index.nav.link.hello"/>&nbsp;${pageContext.request.userPrincipal.name}</a>
	</div>
<ul class="nav navbar-nav">
  <li class="active">
    <a href="/"><spring:message code="index.nav.link.home"/></a>
  </li>
  <li>
    <a href="/welcome-person"><spring:message code="index.nav.link.add"/></a>
  </li>
  <li>
    <a href="/list-person"><spring:message code="index.nav.link.fetch"/></a>
  </li>
  <li>
    <a href="/logout"><spring:message code="index.nav.link.logout"/></a>
  </li>
</ul>
	<ul class="nav navbar-nav navbar-right">
		<li>
			<a href="/?language=en"><span class="glyphicon glyphicon-user"></span> English</a>
		</li>
      <li>
      	<a href="/?language=hi"><span class="glyphicon glyphicon-log-in"></span> Hindi</a>
      	</li>
	</ul>
</div>
</nav>
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<br/><br/>
			<h1 class="myidx">
				<spring:message code="index.head"/>
			</h1>
			<br/><br/>
			<section>
			<ul class="myListType">
			<li>
			<h3 class="notice notice-danger"><spring:message code="index.list.danger"/></h3>
			</li>
			<br/>
			<li>
			<h3 class="notice notice-warning"><spring:message code="index.list.warning"/></h3>
			</li>
			<br/>
			<li>
			<h3 class="notice notice-info"><spring:message code="index.list.info"/></h3>
			</li>
			<br/>
			<li>
			<h3 class="notice notice-dark"><spring:message code="index.list.dark"/></h3>
			</li>
			<br/>
			<li>
			<h3 class="notice notice-primary"><spring:message code="index.list.primary"/></h3>
			</li>
			<br/>
			<li>
			<h3 class="notice notice-success"><spring:message code="index.list.success"/></h3>
			</li>
			</ul>
			</section>
			<br/>
		</div>
	</div>
</div>
</body>
</html>