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

		<form id="bookingForm">
			<div class="controlHolder">
				<div class="controlHolder">

					<!-- Serach string -->
					<div class="control-group">
						<label class="control-label" for="search">Search units</label>
						<div class="controls">
							<input type="text" id="Search" name="search" placeholder="String"
								class="form-control input-normal">

						</div>
					</div>

					<!-- City -->
					<div class="control-group">
						<label class="control-label" for="city">City:</label>
						<div class="controls">
							<select class="form-control ">
								<option value="all">Default</option>
								<option value="s1">Select1</option>
								<option value="s2">Select2</option>
								<option value="s2">Select3</option>
							</select>
						</div>
					</div>
					<!-- City -->
					<div class="control-group">
						<label class="control-label" for="city">City:</label>
						<div class="controls">
							<select class="form-control ">
								<option value="all">Default</option>
								<option value="s1">Select1</option>
								<option value="s2">Select2</option>
								<option value="s2">Select3</option>
							</select>
						</div>
					</div>
					<!-- City -->
					<div class="control-group">
						<label class="control-label" for="city">City:</label>
						<div class="controls">
							<select class="form-control ">
								<option value="all">Default</option>
								<option value="s1">Select1</option>
								<option value="s2">Select2</option>
								<option value="s2">Select3</option>
							</select>
						</div>
					</div>
				</div>
			</div>

			<a class="btn-default btn1" data-type="submit" href="#">Book now!</a>
		</form>
	</div>
</div>
<div class="col-lg-9 col-md-9 col-sm-12 margBot pull-right slider-box">
	<div class="search-content-box">

		<table id="units"
			class="table table-bordered table-hover table-striped">
			<thead>
				<tr>
					<th>activity</th>
					<th>date Of Registration</th>
					<th>club</th>
					<security:authorize access="hasRole('ROLE_ADMIN')">
						<th>delete</th>
					</security:authorize>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${units}" var="unit">
					<tr>
						<td>${unit.activity}</td>
						<td>${unit.dateOfRegistration}</td>
						<td>${unit.club.name}</td>
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

