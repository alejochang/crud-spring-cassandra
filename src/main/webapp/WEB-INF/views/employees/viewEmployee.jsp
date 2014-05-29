<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page session="false" import="com.alejandro.crud.utils.*"%>
<html>
<head>
<title>View</title>
<link rel="stylesheet" type="text/css" href="../css/crud.css" />
</head>
<body>
	<div id="header" class="header">
		<div id="headerTitle" class="headerTitle">Employee Contact Manager</div>
		<div class="subHeader">
		    <div id="subHeaderTitle" class="subHeaderTitle" align="right">View - Employee Contact</div>
		</div>
	</div>
	<form method="POST">
		<fieldset>
			<div class="form-row">
				<label for="userName">Username:</label> <span class="input"><input
					id="userName" name="userName" type="text"
					value="${employee.userName}" readonly="readonly" />
				</span>
			</div>
			<div class="form-row">
				<label for="firstName">First Name:</label> <span class="input"><input
					id="firstName" name="firstName" type="text"
					value="${employee.firstName}" readonly="readonly" />
				</span>
			</div>
			<div class="form-row">
				<label for="lastName">Last Name:</label> <span class="input"><input
					id="lastName" name="lastName" type="text"
					value="${employee.lastName}" readonly="readonly" />
				</span>
			</div>
			<div class="form-row">
				<label for="birthDate">Birth Date (YYYY-DD-MM):</label> <span
					class="input"><input id="birthDate" name="birthDate"
					type="text"
					value="<fmt:formatDate value="${employee.birthDate}"  pattern="yyyy-MM-dd"/>"
					readonly="readonly" />
				</span>
			</div>
			<div class="form-row">
				<label for="gender">Gender:</label> <span class="input"> <input
					id="gender" name="gender" type="text" value="${employee.gender}"
					readonly="readonly" /> </span>
			</div>
			<div class="form-row">
				<label for="hireDate">Hire Date (YYYY-DD-MM):</label> <span
					class="input"><input id="hireDate" name="hireDate"
					type="text"
					value="<fmt:formatDate value="${employee.hireDate}"  pattern="yyyy-MM-dd"/>"
					readonly="readonly" />
				</span>
			</div>
			<div class="form-row">
				<label for="position">Position:</label> <span class="input"><input
					id="position" name="position" type="text"
					value="${employee.position}" readonly="readonly" />
				</span>
			</div>
			<div class="form-row">
				<label for="active">Active:</label> <span class="input"><input
					id="active" name="active" type="checkbox" checked="${employee.active == true ? 'true' : 'false'}" disabled="disabled"/>
				</span>
			</div>
			<div class="form-buttons">
	            <div class="button">
					<input type="submit" id="edit" name="_eventId_edit" value="Edit" />
					<input type="submit" id="view" name="_eventId_delete" value="Delete" />
					<input type="submit" id="cancel" name="_eventId_cancel" value="Cancel" />
				</div>
			</div>
		</fieldset>
	</form>
</body>
</html>
