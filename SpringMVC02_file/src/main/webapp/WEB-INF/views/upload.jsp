<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form method="post" enctype="multipart/form-data" modelAttribute="uploadFile" action="upload">
		<h3>upload form</h3>
		file<br>
		<input type="file" name="mpfile"><br>
		<p style="color:red; font-weight: bold;"><form:errors path="mpfile"/></p><br>
		description<br>
		<textarea rows="10" cols="40" name="desc"></textarea><br>
		<input type="submit" value="send">
	</form:form>
</body>
</html>