<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
</head>
<style>
	.red {
		color: red;
	}
	.btn.show {
		display: block;
	}
	.hidden {
		display: none;
	}
</style>	


<body>
	<%
	String baoLoiDangNhap = request.getAttribute("loiTenDangNhap")+"";
	baoLoiDangNhap = (baoLoiDangNhap.equals("null"))?"":baoLoiDangNhap;

	String baoLoiMatKhau = request.getAttribute("loiMatKhau")+"";
	baoLoiMatKhau = (baoLoiMatKhau.equals("null"))?"":baoLoiMatKhau;
	
	String tenDangNhap= request.getAttribute("tenDangNhap")+"";	
	tenDangNhap = (tenDangNhap.equals("null"))?"":tenDangNhap;
	
	String hoVaTen= request.getAttribute("hoVaTen")+"";
	hoVaTen = (hoVaTen.equals("null"))?"":hoVaTen;
	
	String gioiTinh= request.getAttribute("gioiTinh")+"";
	gioiTinh = (gioiTinh.equals("null"))?"":gioiTinh;
	
	String ngaySinh= request.getAttribute("ngaySinh")+"";
	ngaySinh = (ngaySinh.equals("null"))?"":ngaySinh;
	
	String diaChiKhachHang= request.getAttribute("diaChiKhachHang")+"";
	diaChiKhachHang = (diaChiKhachHang.equals("null"))?"":diaChiKhachHang;
	
	String diaChiMuaHang= request.getAttribute("diaChiMuaHang")+"";
	diaChiMuaHang = (diaChiMuaHang.equals("null"))?"":diaChiMuaHang;
	
	String diaChiNhanHang= request.getAttribute("diaChiNhanHang")+"";
	diaChiNhanHang = (diaChiNhanHang.equals("null"))?"":diaChiNhanHang;
	
	String dienThoai= request.getAttribute("dienThoai")+"";
	dienThoai = (dienThoai.equals("null"))?"":dienThoai;
	
	String email= request.getAttribute("email")+"";
	email = (email.equals("null"))?"":email;
	
	String dongYDieuKhoan= request.getAttribute("dongYDieuKhoan")+"";
	dongYDieuKhoan = (dongYDieuKhoan.equals("null"))?"":dongYDieuKhoan;
	
	String dongYNhanMail= request.getAttribute("dongYNhanMail")+"";
	dongYNhanMail = (dongYNhanMail.equals("null"))?"":dongYNhanMail;
	%>
	<%
String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
%>
	<jsp:include page="../header.jsp"></jsp:include>
	<div class= "container">
		<h1 class="text-center">Chào mừng đến trang đăng ký</h1>
			<form action="<%=url%>/khach-hang" method="post">
				<input type="hidden" name="hanhDong" value="dang-ky">
				<div class="row">
					<div class="col-sm-6">
						<h3>Tài Khoản</h3>
						<div class="mb-3">
						  <label for="tenDangNhap" class="form-label">Tên đăng nhập <span class="red">* <%=baoLoiDangNhap %></span>
						  
						   </label>
						  <input value="<%= tenDangNhap %>" type="text" class="form-control" id="tenDangNhap" aria-describedby="emailHelp" name="tenDangNhap" va  required>				 
						</div>
						<div class="mb-3">
						  <label for="matKhau" class="form-label">Mật khẩu <span class="red">* <%= baoLoiMatKhau %></span></label>
						  <input type="password" class="form-control" id="matKhau" name="matKhau" required>
						</div>
						<div class="mb-3">
							<label for="xacNhanMatKhau" class="form-label">Password <span class="red">*</span></label>
							<span class="thongBaoMatKhau red"></span>
							<input type="password" class="form-control" id="xacNhanMatKhau" name="xacNhanMatKhau" required>
						</div>
						<hr/>
	
						<h3>Thông tin khách hàng </h3>
						<div class="mb-3">
							<label for="hoVaTen" class="form-label">Tên khách hàng <span class="red">*</span> </label>
							<input value="<%=hoVaTen %>" type="text" class="form-control" id="hoVaTen" aria-describedby="emailHelp" name="hoVaTen" required>				 
						</div>
						<div class="mb-3">
							<select name="gioiTinh" class="form-select" aria-label="Default select example">
								<option selected>Chọn giới tính của bạn</option>
								<option value="Nam"  <%=(gioiTinh.equals("Nam"))?"selected='selected'":"" %> >Nam</option>
								<option value="Nữ" <%= (gioiTinh.equals("Nữ")?"selected='selected'":"") %>>Nữ</option>
								<option value="Khác" <%= (gioiTinh.equals("Khác")?"selected='selected'":"")%>>Khác</option>
							  </select>			 
						</div>
						<div class="mb-3">
							<label for="ngaySinh" class="form-label">Ngày sinh <span class="red">*</span> </label>
							<input value="<%= ngaySinh %>" type="date" class="form-control" id="ngaySinh" aria-describedby="emailHelp" name="ngaySinh" required>				 
						</div>
	
					</div>
					<div class="col-sm-6">
						<h3>Địa chỉ</h3>
						<div class="mb-3">
							<label for="diaChiKhachHang" class="form-label">Địa chỉ khách hàng <span class="red">*</span> </label>
							<input value="<%=diaChiKhachHang %>" type="text" class="form-control" id="diaChiKhachHang" aria-describedby="emailHelp" name="diaChiKhachHang" required>				 
						</div>
						<div class="mb-3">
							<label for="diaChiMuaHang" class="form-label">Địa chỉ mua hàng <span class="red">*</span> </label>
							<input value="<%= diaChiMuaHang%>" type="text" class="form-control" id="diaChiMuaHang" aria-describedby="emailHelp" name="diaChiMuaHang" required>				 
						</div>
						<div class="mb-3">
							<label for="diaChiNhanHang" class="form-label">Địa chỉ nhận hàng <span class="red">*</span> </label>
							<input value="<%= diaChiNhanHang %>" type="text" class="form-control" id="diaChiNhanHang" aria-describedby="emailHelp" name="diaChiNhanHang" required>				 
						</div>
						<div class="mb-3">
							<label for="dienThoai" class="form-label">Điện thoại</label> 
							<input value="<%=dienThoai %>" type="tel" class="form-control" id="dienThoai" name="dienThoai" required>
						</div>
						<div class="mb-3">
							<label for="email" class="form-label">Email</label> <input
							   value="<%=email%>"	type="email" class="form-control" id="email" name="email">
						</div>
						<hr />
						<div class="mb-3">
							<label for="dongYDieuKhoan" class="form-label">Đồng ý với
								<a>điều khoản của công ty </a><span id="red">*</span>
							</label> <input type="checkbox" class="form-check-input"
								id="dongYDieuKhoan" name="dongYDieuKhoan" required="required"
								<%= dongYDieuKhoan.equals("on") ? "checked" : "" %>
								>
						</div>
						<div class="mb-3">
							<label for="dongYNhanMail" class="form-label">Đồng ý nhận
								email</label> <input type="checkbox" class="form-check-input"
								id="dongYNhanMail" name="dongYNhanMail"
								 <%= dongYNhanMail.equals("on") ? "checked" : "" %>
								>
						</div>
						<button type="submit" class="btn btn-primary hidden"  >Submit</button>
					</div>

				</div>
			  </form>
			  <form action="dangky"></form>
	</div>
				  
	<jsp:include page="../footer.jsp"></jsp:include>
	<script>
		var matKhau = document.getElementById("matKhau");
		var nhapLai = document.getElementById("xacNhanMatKhau");
		var checkBox = document.getElementById("dongYDieuKhoan");
		nhapLai.addEventListener('input',function() {
			if(nhapLai.value === matKhau.value) {
				document.querySelector('.thongBaoMatKhau').innerText = "";
			}
			else {
				document.querySelector('.thongBaoMatKhau').innerText = "Mật khẩu không khớp";
			}
		})
		checkBox.addEventListener("click",function() {
			if(checkBox.checked) {
				document.querySelector(".hidden").classList.add("show");
			}
			else {
				document.querySelector(".hidden").classList.remove("show");
			}
		})
		if(checkBox.checked) {
				document.querySelector(".hidden").classList.add("show");
			}
			else {
				document.querySelector(".hidden").classList.remove("show");
			}
		
	</script>
</body>
</html>