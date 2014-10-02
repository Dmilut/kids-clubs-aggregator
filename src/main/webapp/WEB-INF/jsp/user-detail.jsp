<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<h1>${user.firstName}</h1>

<c:forEach items="${user.clubs}" var="club">
	<h1>${club.name}</h1>
	<p>${club.description}</p>

	<table>
		<thead>
			<tr>
				<th>City</th>
				<th>Street</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${club.addresses}" var="address">
				<tr>
					<td>${address.city}</td>
					<td>${address.street}</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

</c:forEach>

