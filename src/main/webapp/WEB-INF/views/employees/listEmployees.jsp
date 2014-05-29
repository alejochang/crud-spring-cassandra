<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>${app_name}</title>
<link rel="stylesheet" type="text/css" href="../css/crud.css" />
</head>

<body>
	<div id="header" class="header">

		<div id="headerTitle" class="headerTitle">Employee Contact
			Manager</div>

		<div class="subHeader">
			<div id="subHeaderTitle" class="subHeaderTitle" align="right">Home</div>
		</div>

	</div>
	<form method="POST">
		<input id="gender" name="gender" type="hidden" value="OTHER" />
		<fieldset>
			<div class="form-buttons">
				<div class="button">
					<input type="submit" id="create" name="_eventId_create"
						value="Create" /> <input type="submit" id="search"
						name="_eventId_search" value="Search" /> <input type="submit"
						id="cancel" name="_eventId_cancel" value="Cancel" />
				</div>
			</div>
		</fieldset>
	</form>
</body>
</html>