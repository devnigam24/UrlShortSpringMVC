<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="includes/assets.jsp"%>
</head>
<body>
	<fieldset>
		<h3 style="color: orangered; text-align: center;">${errorMessage}</h3>
		<legend align="left">Signup</legend>
		<div class="row">
			<div class="col s8">
				<form:form action="SignUpServlet" method="post">
					<div class="row">
						<div class="input-field col s6">
							<input name="username" type="text" class="validate" value="${username}" />
							<label for="username">Username</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s6">
							<input name="password" type="password" class="validate" value="" />
							<label for="password">password</label>
						</div>
						<div class="col s4">
							<c:if test="${passwordDonotMatch == 'true'}">
								<h6>password not a match</h6>
							</c:if>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s6">
							<input name="cpassword" type="password" class="validate" value="" /> 
							<label path="cpassword" for="cpassword">Confirm password</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s6">
							<input type="submit" value="Signup">
						</div>
					</div>
				</form:form>
			</div>


			<div class="row col s4">
				<form:form action="LoginServlet" method="post">
					<div class="input-field col s10">
						<input name="username" id="username" type="text" class="validate" value="${username}" /> 
							<label for="username">Username</label>
					</div>
					<div class="input-field col s10">
						<input name="password" id="password"  
								type="text" class="validate" value="" /> 
								<label for="password">password</label>
					</div>
					<div class="row">
						<div class="input-field col s6">
							<input type="submit" value="Login">
						</div>
					</div>
				</form:form>

				<br> <br> <br>
				<div class="row">
					<div class="input-field col s6">
						<input type="button" value="Guest User"
							onclick="window.location.href='publicUrlShortner'">
					</div>
				</div>
			</div>


		</div>
	</fieldset>
</body>
</html>
