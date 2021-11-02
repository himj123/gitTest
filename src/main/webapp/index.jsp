<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String memberId = (String)session.getAttribute("memberId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if(memberId != null){
	%>
		<a href = "logout.me">로그아웃</a>
	<%
		}
		else{
	%>
		<a href = "loginForm.html">로그인</a><br>
		<a href = "registForm.html">회원가입</a><br>
	<%
		}
	%>
</body>
</html>