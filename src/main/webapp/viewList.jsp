<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<div align="center">
		<table border="1" cellpadding="5">
			<caption><h2>List of persons</h2></caption>
			<tr>
				<th>PersonId</th>
				<th>FirstName</th>
				<th>LastName</th>
			</tr>
			<c:forEach var="user" items="${personlist}">
				<tr>
					<td><c:out value="${user.eid}" /></td>
					<td><c:out value="${user.firstName}" /></td>
					<td><c:out value="${user.lastName}" /></td>
					
				</tr>
			</c:forEach>
		</table>
			<a href="addperson.jsp">back</a>
</div>
</body>
</html>