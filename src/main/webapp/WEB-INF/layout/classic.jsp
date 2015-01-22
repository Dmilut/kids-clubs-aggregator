<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<!-- <title>Home</title> -->
<title><tiles:getAsString name="title" /></title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" href="img/favicon.ico" type="image/x-icon">
<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />
<meta name="description" content="Your description">
<meta name="keywords" content="Your keywords">
<meta name="author" content="Your name">
<meta name="format-detection" content="telephone=no" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<%@ include file="../layout/taglib.jsp"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<!-- CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" id="font-awesome-css"
	href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css"
	type="text/css" media="screen">

<!--JS-->
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<body>
	<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
		prefix="tilesx"%>

	<tilesx:useAttribute name="current" />

	<header>
		<div class="container">

			<h1 class="navbar-brand navbar-brand_">
				<a href="index.html"><img src="img/logo.png" alt=""><span>company
						name</span></a>
			</h1>
			<div class="menu-box">
				<div class="button-box">
					<security:authorize access="! isAuthenticated()">
						<a class="${current == 'register' ? 'active' : ''}"
							href="<spring:url value="/register.html" />">Register</a>

						<!-- Button to trigger modal -->
						<a class="${current == 'login' ? 'active' : ''}"
							href="#loginModal" data-toggle="modal">Login</a>
					</security:authorize>

					<security:authorize access="isAuthenticated()">
						<a href="<spring:url value="/account.html" />">My account</a>
						<a href="<spring:url value="/logout" />">Logout</a>
					</security:authorize>
				</div>
				<nav
					class="navbar navbar-default navbar-static-top tm_navbar clearfix"
					role="navigation">

					<ul class="nav sf-menu clearfix sf-js-enabled sf-arrows">
						<li class="${current == 'index' ? 'active' : ''}"><a
							href="<spring:url value="/" />">Home</a></li>

						<security:authorize access="hasRole('ROLE_ADMIN')">
							<li class="${current == 'users' ? 'active' : ''}"><a
								href="<spring:url value="/users.html" />">Users</a></li>
						</security:authorize>

						<li class="${current == 'clubs' ? 'active' : ''}"><a
							href="<spring:url value="/" />">Clubs</a></li>

						<li class="${current == 'parents' ? 'active' : ''}"><a
							href="<spring:url value="/" />">Parents</a></li>

						<li class="${current == 'contacts' ? 'active' : ''}"><a
							href="<spring:url value="/" />">Contacts</a></li>
					</ul>
				</nav>
			</div>
		</div>
	</header>

	<div class="global">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-3 col-sm-12 book-form margBot pull-left">
					<div class="box">
						<h2>Booking</h2>
						<p>Lorem ipsum dolor sit amet conse ctetur adipisicing elit,
							sed do eiusmod tempo.</p>

						<form id="bookingForm">
							<div class="controlHolder">
								<div class="controlHolder">

									<!-- Serach string -->
									<div class="control-group">
										<label class="control-label" for="search">Search units</label>
										<div class="controls">
											<input type="text" id="Search" name="search"
												placeholder="String" class="form-control input-normal">

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

							<a class="btn-default btn1" data-type="submit" href="#">Book
								now!</a>
						</form>
					</div>
				</div>
				<div
					class="col-lg-9 col-md-9 col-sm-12 margBot pull-right slider-box">
					<div class="slider">
					
					<tiles:insertAttribute name="body" />
					
						<!-- <div class="camera_wrap"
							style="display: block; margin-bottom: 21px; height: 441px;">
							<div class="camera_fakehover">
								<div class="camera_src camerastarted">
									<div data-src="img/picture1.jpg"></div>
									<div data-src="img/picture2.jpg"></div>
									<div data-src="img/picture3.jpg"></div>
								</div>
								<div class="camera_target">
									<div class="cameraCont"></div>
								</div>
							</div>
						</div> -->
					</div>
				</div>

				<div class="clearfix"></div>

				<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
					<div class="content-box1">
						<h2 class="color1">
							Parents, join <br> <span>for FREE!</span>
						</h2>
						<p>Lorem ipsum dolor sit amet conse ctetur adipisicing elit,
							sed do eiusmod tempor incididunt ut labore et dolore magna.</p>
						<ul class="list1-1">
							<li><a href="#">Post a job for free.</a></li>
							<li><a href="#">Get full access to search.</a></li>
							<li><a href="#">View unlimited babysitter profiles.</a></li>
							<li><a href="#">Upgrade when you are ready to make
									contact.</a></li>
						</ul>
						<a href="#" class="btn-default btn2" data-type="submit">Join
							Now!</a>
					</div>
					<div class="content-box1">
						<h2 class="color1">
							Our <span>Members</span>
						</h2>
						<ul class="list1 indent">
							<li><a href="#"><em>Parents</em> <span>(433651)</span></a></li>
							<li><a href="#"><em>Babysitters</em> <span>(148565)</span></a></li>
							<li><a href="#"><em>Childminders</em> <span>(44477)</span></a></li>
							<li><a href="#"><em>Nannies</em> <span>(58705)</span></a></li>
							<li><a href="#"><em>Nurseries</em> <span>(14511)</span></a></li>
							<li><a href="#"><em>Private Midwives</em> <span>(75)</span></a></li>
							<li><a href="#"><em>Maternity Nurses</em> <span>(509)</span></a></li>
							<li><a href="#"><em>Private Tutors</em> <span>(15726)</span></a></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-8 col-md-8 col-sm-12">
					<div class="row">
						<div class="col-lg-6 col-md-6 col-sm-6">
							<div class="content-box2 maxheight">
								<h2>Find A Babysitter</h2>
								<h3>Lorem ipsum dolor sit amet conse ctetur adipisicing
									elit.</h3>
								<p class="color1">
									Lorem ipsum dolor sit amet conse ctetur adipisicing elit, sed
									do eiusmod tempor incididunt ut labore et dolore magna. <a
										href="#" class="btn-default btn3"><span
										class="fa fa-caret-right"></span></a>
								</p>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-6">
							<div class="content-box3 maxheight">
								<h2>Parenting advice</h2>
								<h3>Ipsum dolor sit amet conse ctetur adipisicing elit.</h3>
								<p class="color1">
									Dolor sit amet conse ctetur adipisicing elit, sed do eiusmod
									tempor incididunt ut labore et dolore magna. <a href="#"
										class="btn-default btn3"><span class="fa fa-caret-right"></span></a>
								</p>
							</div>
						</div>
					</div>
					<div class="content-box4 child-box">
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6">
								<h2 class="color1">
									Caring babysitters <br> <span>for your kids</span>
								</h2>
								<h3 class="color1">Lorem ipsum dolor sit amet conse ctetur
									adipisicing elit, sed do eiusmod tempor incididunt ut labore
									magna aliqua. Ut enim ad minim veniam.</h3>
								<p>Lorem ipsum dolor sit amet conse ctetur adipisicing elit,
									sed do eiusmod tempor incididunt ut labore et dolore magna
									aliqua. Ut enim ad minim veniam, quis nostrud exercitation
									ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis
									aute irure.</p>
								<a href="#" class="btn-default btn4">Read more</a>
							</div>
						</div>
					</div>
					<div class="content-box4">
						<h2 class="color1">
							Connecting parents <span>and babysitters</span>
						</h2>
						<h3 class="color1">Lorem ipsum dolor sit amet conse ctetur
							adipisicing elit, sed do eiusmod tempor incididunt ut labore et
							dolore magna aliqua.</h3>
						<p>Lorem ipsum dolor sit amet conse ctetur adipisicing elit,
							sed do eiusmod tempor incididunt ut labore et dolore magna
							aliqua. Ut enim ad minim veniam, quis nostrud exercitation
							ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis
							aute irure. Lorem ipsum dolor sit amet conse ctetur adipisicing
							elit, sed do eiusmod tempor incididunt ut labore et dolore magna
							aliqua.</p>
						<a href="#" class="btn-default btn4">Read more</a>
					</div>
				</div>

			</div>
		</div>
	</div>

	<!-- Modal window login -->
	<div class="modal fade" id="loginModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div id="login-overlay" class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Login to site.com</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-xs-6">
							<div class="well">
								<form id="loginForm" action="/j_spring_security_check"
									method="POST">
									<div class="form-group">
										<!-- Name -->
										<label for="inputName" class="sr-only">Email address</label>
										<input type="text" name="j_username" class="form-control"
											placeholder="Name" required autofocus>
										<span class="help-block"></span>
									</div>

									<div class="form-group">
										<!-- Password -->
										<label for="inputPassword" class="sr-only">Password</label>
										<input type="password" name="j_password" class="form-control"
											placeholder="Password" required>
										<span class="help-block"></span>
									</div>

									<div id="loginErrorMsg" class="alert alert-error hide">Wrong
										username og password</div>
									<div class="checkbox">
										<label>
											<input type="checkbox" name="remember" id="remember">
											Remember login
										</label>
										<p class="help-block">(if this is a private computer)</p>
									</div>

									<button type="submit" class="btn btn-success btn-block">Login</button>
									<a href="/forgot/" class="btn btn-default btn-block">Help
										to login</a>
								</form>
							</div>
						</div>
						<div class="col-xs-6">
							<p class="lead">
								Register now for <span class="text-success">FREE</span>
							</p>
							<ul class="list-unstyled" style="line-height: 2">
								<li><span class="fa fa-check text-success"></span> See all
									your orders</li>
								<li><span class="fa fa-check text-success"></span> Fast
									re-order</li>
								<li><span class="fa fa-check text-success"></span> Save
									your favorites</li>
								<li><span class="fa fa-check text-success"></span> Fast
									checkout</li>
								<li><span class="fa fa-check text-success"></span> Get a
									gift <small>(only new customers)</small></li>
								<li><a href="/read-more/"><u>Read more</u></a></li>
							</ul>
							<p>
								<a href="/new-customer/" class="btn btn-info btn-block">Yes
									please, register now!</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /Modal window login -->

	<tiles:insertAttribute name="footer" />

	<script type="text/javascript">
		$(document).ready(function() {
			$("#loader").click(function() {
				// Load the page into the div
				$("#resultreturn").load("register.html");
				// Show the modal dialog
				$("#resultreturn").dialog({
					modal : true
				});
			});
		});
	</script>

</body>
</html>

