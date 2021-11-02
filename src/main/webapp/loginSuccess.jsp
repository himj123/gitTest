<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//Object 영역객체.getAttribute(String attrName)
	MemberVO loginMember = (MemberVO)request.getAttribute("loginMember");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인에 성공한 사용자 정보</h1>
	<b>이름 : </b> <%=loginMember.getMemberName() %><br> <!-- out.print() 역할을 하는 Expression Tag -->
	<b>고향 : </b> <%=loginMember.getMemberCountry() %><br>
	<b>나이 : </b> <%=loginMember.getMemberAge() %><br>
	<b>주소 : </b> <%=loginMember.getMemberAddr1() %><br>
</body>
</html>