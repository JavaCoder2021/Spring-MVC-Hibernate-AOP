<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
<title>Employee Info</title>
<link rel="stylesheet" type="text/css" href="static/css/style.css" />
</head>

<body>
<center>

<h2>Employee Info</h2>

<form:form action = "/saveEmployee" modelAttribute = "employee">

<form:hidden path = "id" />

<table class = "table">

<tr>
<th>Attribute</th>
<th>Value</th>
</tr>

<tr>
<td>Name:</td>
<td>
<form:input path = "name" />
<form:errors path = "name" class = "valid" />
</td>
</tr>

<tr>
<td>Surname:</td>
<td>
<form:input path = "surname" />
<form:errors path = "surname" class = "valid" />
</td>
</tr>

<tr>
<td>Department:</td>
<td>
<form:select path = "department">
    <form:option value="-" label="---Please Select---"/>
    <form:options items="${department}" />
</form:select>
</td>
</tr>

<tr>
<td>Salary:</td>
<td>
<form:input path = "salary" />
<form:errors path = "salary" class = "valid" />
</td>
</tr>

</table>

<br><br>

<input type = "submit" value = "Add / Update Employee">

</form:form>

</center>
</body>

</html>
