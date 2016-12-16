<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Public page</title>
<%@include file="includes/assets.jsp"%>
</head>
<body>
	<h3 style="color: orangered; text-align: center;">${errorMessage}</h3>
	<h3>Welcome ---->>>>Guest User</h3>
	<div class="row col s4">
		<form:form action="UrlShortnerController" method="post">
			<div class="input-field col s6">
				<input name="longUrl" type="text" value="${longUrl}" /> 
				<label for="longUrl">longUrl</label>
			</div>
			<div class="input-field col s4">
				<a id="shortUrl" target="_blank" href="${shortUrl}">${shortUrl}</a>
			</div>
			<div class="input-field col s4">
				<div class="input-field col s6">
					<input type="submit" value="Short It" />
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>