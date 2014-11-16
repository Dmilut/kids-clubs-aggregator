<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<h1>${user.firstName}</h1>

<c:forEach items="${user.units}" var="unit">
	<h1>${unit.club.name}</h1>
	<p>${unit.activity}</p>

	<table class="table table-bordered table-hover table-striped">
		<thead>
			<tr>
				<th>Address</th>
				<th>Contact Info</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${unit.addresses}" var="address">
				<tr>
					<td>${address.city}</td>
					<td>${address.street}</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

</c:forEach>

