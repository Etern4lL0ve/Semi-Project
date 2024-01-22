<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>

    </style>
</head>
<body>
    <%@ include file="views/common/menubar.jsp" %>

     <div>
        <div id="chat-messages">
            <jsp:include page="/views/chat/Chat.jsp"></jsp:include>
        </div> 
     </div>

        <%@ include file="views/common/main.jsp" %>
 

    <jsp:include page="views/common/footer.jsp"></jsp:include>
</body>
</html>
