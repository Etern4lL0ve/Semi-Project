<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String memberPwd = (String)request.getAttribute("memberPwd");
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<div align="center">
		<h2>비밀번호 찾기 결과</h2>
		<p>회원님의 비밀번호는 다음과 같습니다</p>
		<p><strong><%=request.getAttribute("memberPwd") %></strong></p>
		<br>	
		<button onclick="goBack();">로그인 하러가기</button>
	</div>
	<script>
		function goBack() {
			location.href = "<%=contextPath%>"
		}
	</script>
</body>
</html>