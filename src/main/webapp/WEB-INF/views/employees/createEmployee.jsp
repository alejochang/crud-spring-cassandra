<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Create</title>
	<link rel="stylesheet" type="text/css" href="../css/crud.css" />
	<script language="JavaScript" type="text/javascript">
	<!--
	function getGenderSelected(selGender)
	{
		var hdnGender = document.getElementById('gender');
		
		var selIndex = selGender.selectedIndex;
		hdnGender.value = selGender.options[selIndex].value;
	}
	//-->
	</script>
</head>
<body>
	<div id="header" class="header">
		<div id="headerTitle" class="headerTitle">Employee Contact Manager</div>
		<div class="subHeader">
		    <div align="right">Create - Employee Contact</div>
		</div>
	</div>
	<form method="POST">
		<input id="gender" name="gender" type="hidden" value="OTHER" />
		<fieldset>
	        <div class="form-row">
	            <label for="userName">Username:</label>
	            <span class="input"><input id="userName" name="userName" type="text" value=""/></span>
	        </div>
	        <div class="form-row">
	            <label for="firstName">First Name:</label>
	            <span class="input"><input id="firstName" name="firstName" type="text" value=""/></span>
	        </div>
	        <div class="form-row">
	            <label for="lastName">Last Name:</label>
	            <span class="input"><input id="lastName" name="lastName" type="text" value=""/></span>
	        </div>
	        <div class="form-row">
	            <label for="birthDate">Birth Date (YYYY-DD-MM):</label>
	            <span class="input"><input id="birthDate" name="birthDate" type="text" value=""/></span>
	        </div>
	        <div class="form-row">
	            <label for="selGender">Gender:</label>
	            <span class="input">
	            	<select id="selGender" onchange="getGenderSelected(this);">
						<option value="OTHER">-</option>
						<option value="FEMALE">Female</option>
						<option value="MALE">Male</option>
	            	</select>
	            </span>
	        </div>
	        <div class="form-row">
	            <label for="hireDate">Hire Date (YYYY-DD-MM):</label>
	            <span class="input"><input id="hireDate" name="hireDate" type="text" value=""/></span>
	        </div>
	        <div class="form-row">
	            <label for="position">Position:</label>
	            <span class="input"><input id="position" name="position" type="text" value=""/></span>
	        </div>
	        <div class="form-row">
	            <label for="active">Active:</label>
	            <span class="input"><input id="active" name="active" type="checkbox" checked="checked"/></span>
	        </div>
	        <div class="form-buttons">
	            <div class="button">
				<input type="submit" id="save" name="_eventId_save" value="Save" />
			    <input type="submit" id="cancel" name="_eventId_cancel" value="Cancel" />
			    </div>
			</div>
		</fieldset>
	</form>
</body>
</html>