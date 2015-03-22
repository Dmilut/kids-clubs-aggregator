<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>

<div class="col-lg-3 col-md-3 col-sm-12 book-form margBot pull-left">
	<div class="box">
		<h2>Booking</h2>
		<p>Lorem ipsum dolor sit amet conse ctetur adipisicing elit, sed
			do eiusmod tempo.</p>

		<div>

			<form:form method="POST" commandName="clubs" id="bookingForm"
				cssClass="form-horizontal">
				<div class="controlHolder">

					<!-- City -->
					<div class="control-group">
						<form:select path="${city}" name="city" cssClass="form-control"
							multiple="">
							<option value="">Город</option>
							<c:forEach items="${cityList}" var="c">
								<option
									<c:if test="${c eq currentCity}">selected="selected"</c:if>
									value="${c}">${c}</option>
							</c:forEach>
						</form:select>
					</div>
					<!-- /City -->

					<!-- District -->
					<div class="control-group">
						<form:select path="${district}" name="district" cssClass="form-control"
							multiple="">
							<option value="">Район</option>
							<c:forEach items="${districtList}" var="c">
								<option
									<c:if test="${c eq currentDistrict}">selected="selected"</c:if>
									value="${c}">${c}</option>
							</c:forEach>
						</form:select>
					</div>
					<!-- /District -->

					<!-- Subway station -->
					<div class="control-group">
						<form:select path="${subwayStation}" name="subwayStation" cssClass="form-control"
							multiple="">
							<option value="">Станция метро</option>
							<c:forEach items="${subwayStationList}" var="c">
								<option
									<c:if test="${c eq ccurrentSubwayStation}">selected="selected"</c:if>
									value="${c}">${c}</option>
							</c:forEach>
						</form:select>
					</div>
					<!-- /Subway station -->
					<div class="control-group">
						<div class="slider">
							<input type="range" value="1" min="1" max="18" step="1"
								onchange="rangevalue.value=value" name="mynumber1">
							<label>Возраст ребенка</label>
							<output id="rangevalue">1</output>
						</div>
					</div>
					<div class="control-group">
						<div class="slider">
							<input type="range" value="0" min="0" max="10000" step="50"
								onchange="rangevalue1.value=value" name="mynumber2">
							<label>Стоимость в мес.</label>
							<output id="rangevalue1">1</output>
						</div>
					</div>

				</div>
				<input class="btn-default btn btn1" type="submit" name="submit"
					value="Подобрать">
			</form:form>
		</div>
	</div>
</div>

<div class="col-lg-9 col-md-9 col-sm-12 margBot pull-right slider-box">
	<div class="search-content-box">

		<table id="clubs"
			class="table table-bordered table-hover table-striped">
			<thead>
				<tr>
					<th>name</th>
					<th>subway station</th>
					<th>type</th>
					<th>units</th>
					<th>description</th>
					<th>date Of Registration</th>
					<security:authorize access="hasRole('ROLE_ADMIN')">
						<th>delete</th>
					</security:authorize>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${clubs}" var="club">
					<tr>
						<td><a href="<spring:url value="/clubs/${club.id}.html" />">
								${club.name} </a></td>

						<td><c:forEach items="${club.addresses}" var="address">
								<div class="list-group">
									<a href="#" class="list-group-item">${address.subwayStation}
									</a>
								</div>
							</c:forEach></td>

						<td>${club.type}</td>

						<td><c:forEach items="${club.units}" var="unit">
								<div class="list-group">
									<a href="#" class="list-group-item">${unit.activity} </a>
								</div>
							</c:forEach></td>

						<td>${club.description}</td>
						<td>${club.dateOfRegistration}</td>
						<security:authorize access="hasRole('ROLE_ADMIN')">
							<td><a class="btn btn-danger"
								href="<spring:url value="/club/remove/${club.id}.html" />">Delete</a></td>
						</security:authorize>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>