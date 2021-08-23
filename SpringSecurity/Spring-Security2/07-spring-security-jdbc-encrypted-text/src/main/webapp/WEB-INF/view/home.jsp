<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
	<title>luv2code Company Home Page</title>
</head>

<body>
	<h2>luv2code Company Home Page</h2>
	<hr>
	
	<marquee><h3>Welcome to the luv2code company home page!</h3></marquee>

<form:form action="${pageContext.request.contextPath}/logout" method="POST">

<hr>
<!-- diplaying username and role-->
User:<security:authentication property="principal.username"/>
<br><br>
Roles:<security:authentication property="principal.authorities"/>
<hr>
<p>
<security:authorize access="hasRole('MANAGER')">
<a href="${pageContext.request.contextPath}/leaders">Leadership meeting</a>

(only for manager peeps)
<br><br>
</security:authorize>

<!-- adding link to point admin-->
<security:authorize access="hasRole('ADMIN')">
<a href="${pageContext.request.contextPath}/systems">IT systems meeting</a>
(only for admin)
</security:authorize>


<hr>

<input type="submit" value="Logout"/>

</form:form>

</body>

</html>