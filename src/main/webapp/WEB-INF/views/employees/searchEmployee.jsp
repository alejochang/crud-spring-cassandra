<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Create</title>
	<link rel="stylesheet" type="text/css" href="../css/crud.css" />
	</head>
<body>
	<div id="header" class="header">
		<div id="headerTitle" class="headerTitle">Employee Contact Manager</div>
		<div class="subHeader">
		    <div id="subHeaderTitle" class="subHeaderTitle" align="right">Search - Employee Contact</div>
		</div>
	</div>
	<form method="POST">
		<fieldset>
	        <div class="form-row">
	            <label for="userName">Username:</label>
	            <span class="input"><input id="userName" name="userName" type="text" value=""/></span>
	        </div>
	        
	        <div >
				<input type="submit" id="search" name="_eventId_search" value="Search" />
			    <input type="submit" id="cancel" name="_eventId_cancel" value="Cancel" />
			</div>
		</fieldset>
	</form>
</body>