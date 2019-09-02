<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>두번째 페이지입니다.</h1>
<h1>당신의 이름은 ${applicationScope.name }입니다. </h1>
<h1>당신의 이름은 ${sessionScope.name }입니다. </h1>
<h1>당신의 이름은 ${requestScope.name }입니다. </h1>
<h1>당신의 이름은 ${pageScope.name }입니다. </h1>
</body>
</html>