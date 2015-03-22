<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>

<div class="col-lg-12">
	<script type="text/javascript" charset="utf-8"
		src="//api-maps.yandex.ru/services/constructor/1.0/js/?sid=drFkfL7l0L_CXgvJ25UQIeGzhUQxy16j&width=600&height=450"></script>
</div>
<div class="formBox">
	<div class="container">
		<div class="row">
			<div class="col-lg-4 col-md-4 col-sm-4">
				<div class="content-box1 maxheight">
					<h2 class="color1">Наш адрес</h2>
					<div class="info">
						<h3>Address 1:</h3>
						<p>
							Test company name<br>1111 Saint Petersburg
							Korablestroitelei, 40 korp.1
						</p>
						<h3>Telephones:</h3>
						<p>
							123 456 789 <br> 1098 765 432 1
						</p>
						
					</div>
				</div>
			</div>
			<div class="col-lg-8 col-md-8 col-sm-8">
				<div class="content-box4 maxheight">
					<h2 class="color1">Оставьте отзыв</h2>

					<form id="contact-form">
						<div class="contact-form-loader"></div>
						<fieldset>
							<label class="name form-div-1">
								<input type="text" name="name" placeholder="Имя" value=""
									data-constraints="@Required @JustLetters" />
								<!-- <span class="empty-message">*This field is required.</span> <span
									class="error-message">*This is not a valid name.</span> -->
							</label>
							<label class="email form-div-2">
								<input type="text" name="email" placeholder="Эл. адрес" value=""
									data-constraints="@Required @Email" />
								<!-- <span class="empty-message">*This field is required.</span> <span
									class="error-message">*This is not a valid email.</span> -->
							</label>
							<label class="phone form-div-3">
								<input type="text" name="phone" placeholder="Телефон" value=""
									data-constraints="@Required @JustNumbers" />
								<!-- <span class="empty-message">*This field is required.</span> <span
									class="error-message">*This is not a valid phone.</span> -->
							</label>
							<label class="message form-div-4">
								<textarea name="message" placeholder="Сообщение"
									data-constraints='@Required @Length(min=20,max=999999)'></textarea>
								<!-- <span class="empty-message">*This field is required.</span> <span
									class="error-message">*The message is too short.</span> -->
							</label>
							<!-- <label class="recaptcha"><span class="empty-message">*This field is required.</span></label> -->
							<div>
								<a href="#" data-type="submit" class="btn-default btn4">Отправить</a>
							</div>
						</fieldset>
						<div class="modal fade response-message">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true">&times;</button>
										<h4 class="modal-title">Modal title</h4>
									</div>
									<div class="modal-body">You message has been sent! We
										will be in touch soon.</div>
								</div>
							</div>
						</div>
					</form>

				</div>
			</div>
		</div>
	</div>
</div>