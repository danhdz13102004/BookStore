<%@page import="modal.KhachHang"%>
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
	.red {
		color: red;
	}
</style>
</head>
<body>
	<%
		String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
		String baoLoi = (String) request.getAttribute("baoLoi");
		if(baoLoi == null) baoLoi = "";
		Object  obj = session.getAttribute("khachHang");
		KhachHang khachHang = null;
		if(obj != null) {
			 khachHang = (KhachHang)obj;
		}
		if(khachHang == null) {
			session.setAttribute("baoLoi", "Bạn phải đăng nhập trước khi sử dụng tính năng này!");
	%>	
	<script type="text/javascript">
	
	 window.location.href = 'dangnhap.jsp';
	</script>
	<% }else { %>
	<jsp:include page="../header.jsp"></jsp:include>
	<h2 class="text-center"> Đổi mật khẩu</h3>
	<div class="container">
		<form action="<%= url %>/khach-hang" method="post">
		<input type="hidden" name="hanhDong" value="doi-mat-khau">
			<span class="red"> <%= baoLoi %></span>
			<div class="mb-3">
						<label for="matKhauHienTai" class="form-label">Nhập mật khẩu hiện tại
						</label>
						<input  name="matKhauHienTai" type="password" class="form-control" id="matKhauHienTai" aria-describedby="emailHelp">
			</div>
			<div class="mb-3">
						<label for="matKhauMoi" class="form-label">Password</label>
						<input name="matKhauMoi" type="password" class="form-control" id="matKhauMoi">
			</div>
			<div class="mb-3">
						<label for="matKhauMoiXacNhan" class="form-label">Password</label>
						<input name="matKhauMoiXacNhan" type="password" class="form-control" id="matKhauMoiXacNhan">
			</div>
			<button type="submit" class="btn btn-primary">Xác nhận thay đổi</button>
		</form>
	</div>
	<jsp:include page="../footer.jsp"></jsp:include>
	<%} %>

</body>
</html>