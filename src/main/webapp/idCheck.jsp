<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
   String memberId = (String)request.getAttribute("memberId");
   boolean memberIdExist = (boolean)request.getAttribute("memberIdExist");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   #idCheckArea{
   width : 380px;
   margin : auto;
   border : 3px solid black;
   text-align: center;
   }
</style>
<script>
	function closeWindow(){
		opener.document.registForm.memberId.value = '<%=memberId%>';
		window.close();
		//self.close();
		//close();				3개 모두 동일
	}
</script>
</head>
<body>
   <section id = "idCheckArea">
      <%
         if(memberIdExist){
      %>
      <h1><%= memberId %>는 사용할 수 없습니다.</h1>
      <form action="idCheck.me">
      	<label for = "memberId">아이디 : </label>
      	<input type = "text" name = "memberId" id = "memberId"/><br>
      	<input type = "submit" value = "적용"/>
      </form>
      <%
         }
         else{
      %>
      <h1><%= memberId %>는 사용할 수 있습니다.</h1>
      <a href = "javascript:closeWindow()">확인</a>
      <%
         }
      %>
   </section>
</body>
</html>