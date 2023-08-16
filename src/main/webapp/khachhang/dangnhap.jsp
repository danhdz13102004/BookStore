<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
	integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
	crossorigin="anonymous"></script>

<style type="text/css">
	.my-contain {
		width: 400px;
		height: 300px;
	}
	.container {
		display: flex;
		align-items: center;
		justify-content: center;
		height: 100vh;
	}
	.red {
		color: red;
	}
	.green {
		color: green;
	}
	
</style>
<%
	String url = request.getScheme() + "://" + request.getServerName()+ ":" + request.getServerPort() + request.getContextPath();
%>

</head>
<body>
	<%
		String baoLoi = (String) request.getAttribute("baoLoi");
		if(baoLoi == null) baoLoi = "";
		String tenDangNhap = (String) request.getAttribute("tenDangNhap");
		if(tenDangNhap == null) tenDangNhap = "";
		String thanhCong = (String) request.getAttribute("thanhCong");
		if(thanhCong == null) thanhCong = "";

	%>
	<jsp:include page="../header.jsp"></jsp:include>
	<div class="container">
		<div class="my-contain">
			<form action="<%= url %>/khach-hang" method="post">
				<input type="hidden" name="hanhDong" value="dang-nhap">
				<h3>Đăng nhập</h3>
				   <span class="red"> <%= baoLoi %></span>
				   <span class="green"> <%= thanhCong %></span>
				  <div class="mb-3">
				    <label for="tenDangNhap" class="form-label">User name
				    </label>
				    <input value="<%= tenDangNhap %>" name="tenDangNhap" type="text" class="form-control" id="tenDangNhap" aria-describedby="emailHelp">
				  </div>
				  <div class="mb-3">
				    <label for="matKhau" class="form-label">Password</label>
				    <input name="matKhau" type="password" class="form-control" id="matKhau">
				  </div>
				  <button type="submit" class="btn btn-primary">Đăng Nhập</button>
				  <br>
				  <div class="text-center">
					  <a href="dangky.jsp">Chưa có tài khoản? Đăng kí</a>
				  </div>		
			</form>
		</div>
	</div>
	<jsp:include page="../footer.jsp"></jsp:include>

</body>
</html>