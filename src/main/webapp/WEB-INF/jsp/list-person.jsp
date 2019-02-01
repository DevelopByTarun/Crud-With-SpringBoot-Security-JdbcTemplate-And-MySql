<%@ include file="taglib.jsp"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="links.jsp"%>
<title><spring:message code="listp.title"/></title>
</head>
<body>
<nav class="navbar navbar-inverse">
<div class="container-fluid">
	<div class="navbar-header">
		<a class="navbar-brand" id="fonty" href="#"><spring:message code="listp.nav.link.hello"/>&nbsp;${pageContext.request.userPrincipal.name}</a>
	</div>
	<ul class="nav navbar-nav">
  <li>
    <a href="/"><spring:message code="listp.nav.link.home"/></a>
  </li>
  <li>
    <a href="/welcome-person"><spring:message code="listp.nav.link.add"/></a>
  </li>
  <li class="active">
    <a href="/list-person"><spring:message code="listp.nav.link.fetch"/></a>
  </li>
  <li>
    <a href="/logout"><spring:message code="listp.nav.link.logout"/></a>
  </li>
	</ul>
	<ul class="nav navbar-nav navbar-right">
		<li>
			<a href="/list-person?language=en"><span class="glyphicon glyphicon-user"></span> English</a>
		</li>
      <li>
      	<a href="/list-person?language=hi"><span class="glyphicon glyphicon-log-in"></span> Hindi</a>
      	</li>
	</ul>
</div>
</nav>
<div class="container">
	<div class="row">
		<div class="col-md-12">
		<br/><br/>
			<h1 class="show"><spring:message code="listp.head"/></h1>
<br/>
<table class="table table-striped table-bordered">
  <thead class="thead-dark">
    <tr>
      <th><spring:message code="listp.table.id"/></th>
      <th><spring:message code="listp.table.fname"/></th>
      <th><spring:message code="listp.table.lname"/></th>
      <th><spring:message code="listp.table.age"/></th>
      <th><spring:message code="listp.table.city"/></th>
      <th><spring:message code="listp.table.edit"/></th>
      <th><spring:message code="listp.table.delete"/></th>
    </tr>
  </thead>
  <tbody> 
  <c:forEach var="person" items="${personList}">			
	   <tr>
       <td>${person.id}</td>
       <td>${person.firstName}</td>
       <td>${person.lastName}</td>
       <td>${person.age}</td>
       <td>${person.city}</td>
       <td>
       <button type="button" class="btn btn-warning btnOne">
       		<a href="/edit-person/${person.id}"><spring:message code="listp.table.edit.button"/></a>
       	</button>
       </td>
       <td>
       <button type="button" class="btn btn-danger btnTwo">
       		<a href="/delete-person/${person.id}"><spring:message code="listp.table.delete.button"/></a>
       	</button>
       </td>
    </tr>						
</c:forEach>
  </tbody>
</table>
<br/>
		</div>
	</div>
</div>
</body>
</html>