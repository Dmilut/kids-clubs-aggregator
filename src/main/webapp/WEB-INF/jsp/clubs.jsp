<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>


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
						<label class="control-label" for="city">City:</label>
						<div class="controls">

							<form:select path="${city}" name="city" cssClass="form-control">
								<form:option value="" label="--- Select ---" />
								<form:options items="${cityList}" />
							</form:select>


<!-- TODO динамический выпадающий список --> 
<%-- 							<form:select path="${city}" name="city" cssClass="form-control">
								<c:forEach items="${cityList}" var="city" varStatus="status">
									<c:choose>
										<c:when test="${city == currentCity}">
											<!-- <option value="-">--Please Select</option> -->

											<option
												<c:if test="${city == currentCity}">selected="$(city)"</c:if>
												value="${city}">${city}</option>
										</c:when>
										<c:otherwise>
											<!-- <option value="-">--Please Select</option> -->
											<option value="${city}">${city}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</form:select>
 --%>
 
						</div>
					</div>
				</div>
				<input class="btn-default btn btn1" type="submit" name="submit"
					value="Submit">
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
					<th>type</th>
					<th>description</th>
					<th>date Of Registration</th>
					<security:authorize access="hasRole('ROLE_ADMIN')">
						<th>delete</th>
					</security:authorize>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${clubs}" var="unit">
					<tr>
						<td>${club.name}</td>
						<td>${club.type}</td>
						<td>${club.description}</td>
						<td>${unit.dateOfRegistration}</td>
						<security:authorize access="hasRole('ROLE_ADMIN')">
							<td><a class="btn btn-danger"
								href="<spring:url value="/unit/remove/${unit.id}.html" />">Delete</a></td>
						</security:authorize>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

