<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function call(){
		location.href = 'deptinsert';
	}
</script>
</head>
<body>
<h1>부서목록...${name }</h1>
<button onclick="call();">부서 추가</button>
<h2>자료건수...${deptcount } 건</h2>
<hr>
<table border="1">
	<tr>
		<td>부서번호</td>
		<td>부서이름</td>
		<td></td>
	</tr>
	<c:forEach var="dept" items="${deptlist }">
		<tr>
			<td><a href="deptdetail?deptid=${dept.getDepartment_id() }">${dept.getDepartment_id() }</a></td>
			<td>${dept.getDepartment_name() }</td>
			<td><a href="deptdelete?deptid=${dept.getDepartment_id() }">삭제하기</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>