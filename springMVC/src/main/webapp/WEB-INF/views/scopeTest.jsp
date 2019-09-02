<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name = request.getParameter("myname");
		// 프로그램 전체페이지에서 공유
		application.setAttribute("name", name+":app");
		//웹브라우저의 모든 페이지에서 공유(사용자 1인)
		session.setAttribute("name", name+":see"); 
		//요청이 유지되는 동안만 유효
		request.setAttribute("name", name+":req");
		//한 페이지에서만 유효
		pageContext.setAttribute("name", name+":pge"); 
	%>
	<h1>첫번째 페이지입니다.</h1>
	<h1>당신의 이름은 ${applicationScope.name }입니다. </h1>
	<h1>당신의 이름은 ${sessionScope.name }입니다. </h1>
	<h1>당신의 이름은 ${requestScope.name }입니다. </h1>
	<h1>당신의 이름은 ${pageScope.name }입니다. </h1>
	<hr>
	<jsp:include page="scopeTest2.jsp"/>
</body>
</html>