<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<title>All Employees</title>
<link rel="stylesheet" type="text/css" href="static/css/style.css" />
</head>

<body>
<center>

<h2>All Employees</h2>

<table class = "table">

<tr>
<th>Name</th>
<th>Surname</th>
<th>Department</th>
<th>Salary</th>
<th>Update</th>
<th>Delete</th>
</tr>
<c:forEach var = "employee" items = "${employees}">
<c:url var = "updateButton" value = "/updateEmployee">
    <c:param name = "id" value = "${employee.id}" />
</c:url>
<c:url var = "deleteButton" value = "/deleteEmployee">
    <c:param name = "id" value = "${employee.id}" />
</c:url>
<tr>
<td>${employee.name}</td>
<td>${employee.surname}</td>
<td>${employee.department}</td>
<td>${employee.salary}</td>
<td><input type = "button" value = "Update" onclick = "window.location.href = '${updateButton}'"></td>
<td><input type = "button" value = "Delete" onclick = "window.location.href = '${deleteButton}'"></td>
<tr>
</c:forEach>

</table>

<br>

<input type = "button" value = "Add new Employee" onclick = "window.location.href = '/addNewEmployee'">

</center>
</body>

</html>
