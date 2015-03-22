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
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link rel="stylesheet" id="font-awesome-css"
	href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css"
	type="text/css" media="screen">

<!--JS-->
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<body>
	<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
		prefix="tilesx"%>

	<tilesx:useAttribute name="current" />

	<header>
		<div class="container">
			<h1 class="navbar-brand navbar-brand_">
				<a href="index.html"><img
					src="<%=request.getContextPath()%>/resources/img/logo.png" alt=""><span>company
						name</span></a>
			</h1>
			<div class="menu-box">
				<div class="button-box">
					<security:authorize access="! isAuthenticated()">
						<!-- Buttons to trigger modal -->
						<a class="${current == 'register' ? 'active' : ''}"
							href="#registerModal" data-toggle="modal">Регистрация</a>

						<a class="${current == 'login' ? 'active' : ''}"
							href="#loginModal" data-toggle="modal">Вход</a>
					</security:authorize>

					<security:authorize access="isAuthenticated()">
						<a class="${current == 'account' ? 'active' : ''}"
							href="<spring:url value="/account.html" />">Мой профиль</a>
						<a href="<spring:url value="/logout" />">Выход</a>
					</security:authorize>
				</div>
				<nav
					class="navbar navbar-default navbar-static-top tm_navbar clearfix"
					role="navigation">

					<ul class="nav sf-menu clearfix sf-js-enabled sf-arrows">
						<li class="${current == 'index' ? 'active' : ''}"><a
							href="<spring:url value="/" />">Домой</a></li>

						<security:authorize access="hasRole('ROLE_ADMIN')">
							<li class="${current == 'users' ? 'active' : ''}"><a
								href="<spring:url value="/users.html" />">Пользователи</a></li>
						</security:authorize>

						<li class="${current == 'units' ? 'active' : ''}"><a
							href="<spring:url value="/units.html" />">Модули</a></li>

						<li class="${current == 'clubs' ? 'active' : ''}"><a
							href="<spring:url value="/clubs.html" />">Клубы</a></li>

						<li class="${current == 'parents' ? 'active' : ''}"><a
							href="<spring:url value="/parents.html" />">Родителям</a></li>

						<li class="${current == 'contacts' ? 'active' : ''}"><a
							href="<spring:url value="/contacts.html" />">О нас</a></li>
					</ul>
				</nav>
			</div>
		</div>
	</header>

	<div class="global">
		<div class="container">
			<div class="row">
				<tiles:insertAttribute name="body" />
			</div>
		</div>
	</div>


	<!-- Modal window register -->
	<div class="modal fade" id="registerModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div id="login-overlay" class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Регистрация на
						vneurokov.ru</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="well">

							<form:form commandName="user" method="POST"
								cssClass="form-horizontal">
								<c:if test="${param.success eq true}">
									<div class="alert alert-success">Registration successful!</div>

								</c:if>

								<div class="form-group">
									<label for="name" class="col-sm-2 control-label">Имя:</label>
									<div class="col-sm-10">
										<form:input path="name" cssClass="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label for="email" class="col-sm-2 control-label">Эл.
										почта:</label>
									<div class="col-sm-10">
										<form:input path="email" cssClass="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label for="password" class="col-sm-2 control-label">Пароль:</label>
									<div class="col-sm-10">
										<form:password path="password" cssClass="form-control" />
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<input type="submit" value="Зарегистрироваться"
											class="btn btn-success btn-block" />
									</div>
								</div>
							</form:form>
						</div>
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
					<h4 class="modal-title" id="myModalLabel">Войти на
						vneurokov.ru</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-xs-6">
							<div class="well">
								<form id="loginForm" action="/j_spring_security_check"
									method="POST">
									<div class="form-group">
										<!-- Name -->
										<label for="inputName" class="sr-only">Эл. почта</label>
										<input type="text" name="j_username" class="form-control"
											placeholder="Name" required autofocus>
										<span class="help-block"></span>
									</div>

									<div class="form-group">
										<!-- Password -->
										<label for="inputPassword" class="sr-only">Пароль</label>
										<input type="password" name="j_password" class="form-control"
											placeholder="Password" required>
										<span class="help-block"></span>
									</div>

									<div id="loginErrorMsg" class="alert alert-error hide">Wrong
										username og password</div>
									<div class="checkbox">
										<label>
											<input type="checkbox" name="remember" id="remember">
											Запомнить меня
										</label>
										<!-- <p class="help-block">(если эт)</p> -->
									</div>
									<button class="btn btn-default btn-block" type="submit">Войти</button>
								</form>
							</div>
						</div>
						<div class="col-xs-6">
							<p class="lead">
								Зарегистрируйся сейчас <span class="text-success">Бесплатно</span>
							</p>
							<ul class="list-unstyled" style="line-height: 2">
								<li><span class="fa fa-check text-success"></span>
									Выставляй оценки</li>
								<li><span class="fa fa-check text-success"></span>
									Подписывайся на рассылки</li>
								<li><span class="fa fa-check text-success"></span> Узнавай
									расписание</li>
								<li><span class="fa fa-check text-success"></span>
									Запоминай настройки</li>
								<li><span class="fa fa-check text-success"></span> Получай
									подарки <small>(только для новых пользователей)</small></li>
								<li><a href="/read-more/"><u>Узнать больше</u></a></li>
							</ul>
							<p>
								<a href="/new-customer/" class="btn btn-info btn-block">Да,
									зарегистрироваться сейчас!</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /Modal window login -->

	<tiles:insertAttribute name="footer" />


</body>
</html>

