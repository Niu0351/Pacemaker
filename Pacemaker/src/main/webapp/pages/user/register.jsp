<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<title>YoRuHa register</title>
		<%@include file="/pages/common/head.jsp"%>
		<script type="text/javascript">
			$(function () {

				$("#username").blur(function () {
					var username = this.value;
					var usernamePatt = /^\w{5,18}$/;
					$.getJSON("http://localhost:8080/Pacemaker/userServlet","action=ajaxExistUsername&username="+username,function (data) {
						if(data.existUser){
							$("span.errorMsg").text("username exists");
						}
					})
					if(!usernamePatt.test(username)){
						$("span.errorMsg").text("username must contain only letters, numbers and '_' between 5-18 characters!");
					}
					else{
						$("span.errorMsg").text("");
					}
				})

				$("#password").blur(function () {
					var passwordText = this.value;
					var passwordPatt =  /^\S{5,15}$/;
					if (!passwordPatt.test(passwordText)) {
						$("span.errorMsg").text("password cannot contain space and must be between 5 to 15 characters!");
					} else{
						$("span.errorMsg").text("");
					}
				})


				$("#repwd").blur(function () {
					var repwdText = this.value;
					var passwordText = $("#password").val();
					if (repwdText != passwordText) {
						$("span.errorMsg").text("password does not match");
					}else{
						$("span.errorMsg").text("");
					}
				})

				// onclick event
				$("#sub_btn").click(function () {

					//username
					var usernameText = $("#username").val();
					var usernamePatt = /^\w{5,18}$/;
					if (!usernamePatt.test(usernameText)) {
						$("span.errorMsg").text("username is not valid");

						return false;
					}


					//password
					var passwordText = $("#password").val();
					var passwordPatt =  /([^\s])/g;
					if (!passwordPatt.test(passwordText)) {
						$("span.errorMsg").text("password is not valid");

						return false;
					}

					//confirm password
					var repwdText = $("#repwd").val();
					if (repwdText != passwordText) {
						$("span.errorMsg").text("password does not match");

						return false;
					}

					// verification code
					var codeText = $("#code").val();

					codeText = $.trim(codeText);

					if (codeText == null || codeText == "") {
						//remind user
						$("span.errorMsg").text("verification code cannot be empty！");

						return false;
					}

					$("span.errorMsg").text("");

				});

			});

		</script>
		<script type="text/javascript">
			//bond onclick event to verification jpg
			$(function () {
				$("#codeImg").click(function () {
					this.src = "${basePath}/kaptcha.jpg";
				})
			})
		</script>
	<style type="text/css">
		.login_form{
			height:420px;
			margin-top: 25px;
		}

	</style>
	</head>
	<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.png" >
		</div>

			<div class="login_banner">

				<div id="l_content">
					<span class="login_word">Thanks for using our device</span>
				</div>

				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>Pacemaker Membership</h1>
								<a style="font-size: 20px;color: red;float:left;margin-left: 40px" href="index.jsp">login</a>
								<span class="errorMsg">
									${requestScope.msg}
								</span>
							</div>
							<br/>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" value="register" name="action">
									<label>username：</label>
									<input class="itxt" type="text" placeholder=""
										   autocomplete="off" tabindex="1" name="username" id="username"
										   value="${requestScope.username}"/>
									<br />
									<br />
									<label>password：</label>
									<input class="itxt" type="password" placeholder=""
										   autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>confirm password：</label>
									<input class="itxt" type="password" placeholder=""
										   autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>Verification code：</label>
									<input class="itxt" placeholder="" type="text" style="width: 70px;" name="code" id="code"/>
									<img alt="" id="codeImg" src="${basePath}/kaptcha.jpg" style="width: 100px; height: 40px">
									<br />
									<br />
									<input type="submit" value="register" id="sub_btn" />
								</form>
							</div>

						</div>
					</div>
				</div>
			</div>
		<%@include file="/pages/common/footer.jsp"%>
	</body>
</html>