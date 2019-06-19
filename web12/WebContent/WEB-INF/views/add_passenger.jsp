<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Neha Airlines</title>
<link rel="stylesheet" href="resources/css/normalize.css">
<link rel="stylesheet" href="resources/css/theme.css">

</head>
<body>

	<div class="container">

		<div class="title">Add a passenger</div>

		<%
		if(request.getAttribute("error") != null) {
		%>
			<fieldset>
			<legend>Errors</legend>
			<ul>
			<%
				if(request.getAttribute("firstNameError") != null){
			 %>
			 	<li class="error">First Name cannot be empty</li>
			 <%
			 }
			  %>
			  
			  <%
				if(request.getAttribute("lastNameError") != null){
			 %>
			 	<li class ="error">Last Name cannot be empty</li>
			 <%
			 }
			  %>
			  
			  <%
				if(request.getAttribute("doberror") != null){
			 %>
			 	<li class ="error">Date of Birth is Invalid</li>
			 <%
			 }
			  %>
			  </ul>
			
			</fieldset>
		<%
		}
		%>
		
		<fieldset>

			<legend>Passenger details</legend>

			<form action="AddPassenger" method="post">

				<div class="inputField">
					<label for="first-name" class="inputLabel">First name: </label> <input
						name="first-name" type="text" value="<%= request.getAttribute("first_name") %>"></input>
				</div>

				<div class="inputField">
					<label for="last-name" class="inputLabel">Last name: </label> <input
						name="last-name" type="text" value="<%= request.getAttribute("last_name") %>"></input>
				</div>

				<div class="inputField">
					<label for="dob" class="inputLabel">Date of birth: </label> <input
						name="dob" type="text" value =<%= request.getAttribute("dob") %>></input>
				</div>

				<div class="inputField">
					<label for="first-name" class="inputLabel">Gender: </label> <select
						name="gender">
						<option value="Male">Male</option>
						<option valuie="Female">Female</option>
					</select>
				</div>
		</fieldset>

		<div class="inputField" id="submitField">
			<input id="submitBtn" type="submit" value="Add new passenger"></input>
		</div>


		</form>




	</div>

</body>
</html>