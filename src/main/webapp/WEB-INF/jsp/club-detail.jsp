<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>


<div class="col-lg-9 col-md-9 col-sm-12 margBot slider-box pull-left">
	<div class="search-content-box">
		<h3 class="color1 pull-right">${club.name}</h3>
		<p>${club.description}</p>

<%-- 
		<th>name</th>
		<th>description</th>
		<th>email</th>
		<th>date Of Registration</th>
		<th>Activity</th>

		<td>${club.name}</td>
		<p>${club.description}</p> --%>
		<%-- <td>${user.email}</td>
					<td>${user.dateOfRegistration}</td>
					<td><c:forEach items="${user.units}" var="unit">
							<tr>
								<td>${unit.activity}</td>
							</tr>
						</c:forEach></td> --%>

	</div>
</div>

<div class="col-lg-3 col-md-3 col-sm-12 book-form margBot pull-right">
	<div class="box">
		<h2>Booking</h2>
		<p>Lorem ipsum dolor sit amet conse ctetur adipisicing elit, sed
			do eiusmod tempo.</p>

		<form id="bookingForm">
			<div class="controlHolder">
				<div class="controlHolder">

					<!-- Search string -->
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

