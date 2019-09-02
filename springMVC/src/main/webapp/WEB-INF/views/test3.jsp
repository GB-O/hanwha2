<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${company }</h1>
	<h1>${dept }</h1>
	<h1>${myname }</h1>
<hr>

<form action="paramtest">
	
	id : <input type="number" name="userid"><br>
	name : <input type="text" name="username"><br>
	<input type="submit" value="서버전송">
	
</form>

<form action="paramtest2">
	id : <input type="number" name="userid"><br>
	name : <input type="text" name="username"><br>
	<input type="submit" value="서버전송">
</form>
</body>
</html>