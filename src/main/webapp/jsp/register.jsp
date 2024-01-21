<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>RegistrationForm_v2 by Colorlib</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<!-- MATERIAL DESIGN ICONIC FONT -->
		<link rel="stylesheet" href="assets/fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">
		
		<!-- STYLE CSS -->
		<link rel="stylesheet" href="assets/css/style.css">
	</head>

	<body>

		<div class="wrapper" style="background-image: url('assets/images/bg-registration-form-2.jpg');">
			<div class="inner">
				<form action="register" method="post">
					<h3>Registration Form</h3>
					<div class="form-group">
						<div class="form-wrapper">
							<label for="">First Name</label>
							<input type="text" class="form-control" name="firstname">
						</div>
						<div class="form-wrapper">
							<label for="">Last Name</label>
							<input type="text" class="form-control" name="lastname">
						</div>
					</div>
					<div class="form-wrapper">
						<label for="">Email</label>
						<input type="text" class="form-control" name="email">
					</div>
					<div class="form-wrapper">
						<label for="">Password</label>
						<input type="password" class="form-control" name="password">
					</div>
					<div class="form-wrapper">
						<label for="">Confirm Password</label>
						<input type="password" class="form-control" name="confirmpassword">
					</div>
					<div class="checkbox">
						<label>
							<input type="checkbox"> I accept the Terms of Use & Privacy Policy.
							<span class="checkmark"></span>
						</label>
					</div>
					<button>Register Now</button>
					
					<%
					String regMsg = (String)session.getAttribute("msg");

					if (regMsg != null) {
					%>
					<div class="alert alert-success" role="alert"><%=regMsg%> Login <a href="login">Click Here</a></div>
					<%
						session.removeAttribute("msg");
					}
					%>
					
					
					<%String s1=(String)session.getAttribute("msg") ;
					if(s1!=null){
					%>
					
					<%=s1 %>
					<%} session.removeAttribute("failed");%>
				</form>
				<div style="margin-top: -364px; margin-left: 676px;">
					<img style="height: 283px; width: 370px;" src="assets/images/reg.jpg">
				</div>
			</div>
		</div>
		
	</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>