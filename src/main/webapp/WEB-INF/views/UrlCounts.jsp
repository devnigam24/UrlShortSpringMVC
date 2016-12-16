<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="com.fullerton.edu.cpsc.cpsc476.pojo.URL"%>
<html>
<head>
<%@include file="includes/assets.jsp"%>
</head>
<body>
	<h3>Welcome ---->>>>${userName}</h3>
	
	<div style="border:5px black solid;">
			<div class="row">
			<ul >
				<li class="col s6" data-field="longUrl">Long Url</li>
				<li class="col s5" data-field="ShortUrl">Short Url</li>
				<li class="col s1" data-field="urlCount">Hits</li>
				</ul>
			</div>
		
			<c:forEach  var="i" items="${URLlist}">			
				<div class="row">
				<ul >
					<li style="overflow:hidden;" class="col s5">${i.getLongUrl()}</li>
					<li class="col s1"></td>
					<li class="col s5">${i.getShortUrl()}</li>
					<li class="col s1">${i.getHits()}</li>
					</ul>
				</div>
							
			</c:forEach>
		
	</div>

	<div class="row col s4">
		<form action="logOut" method="post">
			<div class="input-field col s6 right">
				<input type="submit" value="Logout">
			</div>
		</form>
	</div>
</body>
</html>