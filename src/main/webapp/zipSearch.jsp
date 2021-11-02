<%@page import="vo.ZipCodeVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
	ArrayList<ZipCodeVO> zipCodeList = (ArrayList<ZipCodeVO>)request.getAttribute("zipCodeList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#zipSearchArea {
	width: 380px;
	margin: auto;
	border: 3px solid black;
	text-align: center;
}
</style>
<script>
	function confirmZipCode(zipCode, basicAddr) {
		
		opener.document.registForm.memberZipCode.value = zipCode;
		opener.document.registForm.memberAddr1.value = basicAddr;
		self.close(); //윈도우 창 닫을때
		
	}
</script>
</head>
<body>
	<section id="zipSearchArea">
	<%
		if(zipCodeList != null && zipCodeList.size() > 0){
	%>
		<table>
			<tr>
				<td>우편번호</td>
				<td>기본주소</td>
			</tr>
			<%
				for(int i = 0; i < zipCodeList.size(); i++){
					//기본주소 생성
					String basicAddr = zipCodeList.get(i).getDou()
					+ " " + zipCodeList.get(i).getSi()
					+ " " + zipCodeList.get(i).getGu()
					+ " " + zipCodeList.get(i).getRo()
					+ " " + zipCodeList.get(i).getBunzi();
			%>
			<tr>
				<td><a href="javascript:confirmZipCode('<%=zipCodeList.get(i).getZipCode()%>', '<%=basicAddr%>')"><%=zipCodeList.get(i).getZipCode()%></a></td>
				<td><%=basicAddr%></td>
			</tr>
			<%
			System.out.println(zipCodeList.get(i).getZipCode() + "ok");
			}
			%>
		</table>
	<%		
		}
	%>
		<h1>검색할 도로명 입력</h1>
		<form action="zipSearch.me" method="POST">
			<label for="ro">도로명 : </label> <input type="text" name="ro" id="ro" /><br>
			<input type="submit" value="검색">
		</form>
	</section>
</body>
</html>