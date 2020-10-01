<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<div align="center">
		<table border="1" cellpadding="5">
			<caption><h2>List of persons</h2></caption>
			<tr>
				<th>AddressId</th>
				<th>Street</th>
				<th>city</th>
				<th>state</th>
				<th>postal</th>
			</tr>
			<c:forEach var="user" items="${addresslist}">
				<tr>
					<td><c:out value="${user.aid}" /></td>
					<td><c:out value="${user.street}" /></td>
					<td><c:out value="${user.city}" /></td>
					<td><c:out value="${user.state}" /></td>
					<td><c:out value="${user.postCode}" /></td>
					
				</tr>
			</c:forEach>
		</table>
			<a href="addperson.jsp">back</a>
</div>
</body>
</html>