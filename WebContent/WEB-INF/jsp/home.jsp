<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to Student Managment System</title>
</head>
<body>
<div align="center">
	<form  method="post" action="${pageContext.request.contextPath}/login">

<table class="formtable">
<tr><td class="label">Email: </td><td><input name="email" type="text" /></td></tr>
<tr><td class="label">Password: </td><td><input name="password" type="password"></td></tr>
<tr><td class="label"> </td><td><input value="Login" type="submit" /></td></tr>
</table>
</form>
</div>
</body>
</html>