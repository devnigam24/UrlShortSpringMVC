<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
							<form:input path="username" id="username"  
								type="text" class="validate" value="${username}" /> 
								<form:label path="username" for="username">Username</form:label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s6">
							<form:input path="password" id="password"  
								type="text" class="validate" value="" /> 
								<form:label path="password" for="password">password</form:label>
						</div>
						<div class="col s4">
							<c:if test="${passwordDonotMatch == 'true'}">
								<h6>password not a match</h6>
							</c:if>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s6">
							<form:input path="cpassword" id="cpassword"  
								type="text" class="validate" value="" /> 
								<form:label path="cpassword" for="cpassword">Confirm password</form:label>
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
						<form:input path="username" id="username"  
								type="text" class="validate" value="${username}" /> 
								<form:label path="username" for="username">Username</form:label>
					</div>
					<div class="input-field col s10">
						<form:input path="password" id="password"  
								type="text" class="validate" value="" /> 
								<form:label path="password" for="password">password</form:label>
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
							onclick="window.location.href='publicUrlShortner.jsp'">
					</div>
				</div>
			</div>


		</div>
	</fieldset>
</body>
</html>
