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
    String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
	+ request.getContextPath();
    %>
	<h1>Chúc mừng đăng kí thành công, kiểm tra email của bạn để hoàn tất việc đăng kí</h1>
	<script>
         setTimeout(function(){
            window.location.href = 'index.jsp';
         }, 3000);
     </script>
</body>
</html>