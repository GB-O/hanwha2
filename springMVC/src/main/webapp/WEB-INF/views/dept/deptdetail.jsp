<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<c:set var="path" value="${pageConText.request.contextPath}"></c:set>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="deptdetail" method="post">
		<input type="text" name="department_id" value="${dept.department_id }">
		<input type="text" name="department_name" value="${dept.department_name }">
		<img alt="이미지" src ="${dept.fileName}" width="200" height="100">
		${pageConText.request.contextPath}
		
		<input type="submit" value="수정하기"/>
		
	</form>
</body>
</html>