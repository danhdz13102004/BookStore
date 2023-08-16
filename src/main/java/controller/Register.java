package controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.Random;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database_itf.*;
import modal.KhachHang;
import util.MaHoa;
import database_itf.*;
/**
 * Servlet implementation class DangKy
 */
@WebServlet("/dangky")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }
    public String getUTF8(String s) {
    	byte[] bytes = s.getBytes(StandardCharsets.ISO_8859_1);
		s = new String(bytes, StandardCharsets.UTF_8);
		return s;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tenDangNhap = request.getParameter("tenDangNhap");
		String matKhau =  MaHoa.Encode(request.getParameter("matKhau"));
		String matKhauNhapLai = MaHoa.Encode(request.getParameter("xacNhanMatKhau"));
		String hoVaTen = getUTF8(request.getParameter("hoVaTen"));
		String gioiTinh = getUTF8(request.getParameter("gioiTinh"));
		String ngaySinh = request.getParameter("ngaySinh");
		String diaChiKhachHang = getUTF8(request.getParameter("diaChiKhachHang"));
		String diaChiMuaHang = getUTF8(request.getParameter("diaChiMuaHang"));
		String diaChiNhanHang = getUTF8(request.getParameter("diaChiNhanHang"));
		String dienThoai = request.getParameter("dienThoai");
		String email = request.getParameter("email");
		String dongYNhanMail = request.getParameter("dongYNhanMail");
		request.setAttribute("tenDangNhap", tenDangNhap);		
		request.setAttribute("hoVaTen", hoVaTen);
		request.setAttribute("gioiTinh", gioiTinh);
		request.setAttribute("ngaySinh", ngaySinh);
		request.setAttribute("diaChiKhachHang", diaChiKhachHang);
		request.setAttribute("diaChiMuaHang", diaChiMuaHang);
		request.setAttribute("diaChiNhanHang", diaChiNhanHang);
		request.setAttribute("dienThoai", dienThoai);
		request.setAttribute("email", email);
		request.setAttribute("dongYNhanMail", dongYNhanMail);
		
		System.out.println(dongYNhanMail);
		System.out.println(ngaySinh);
		String loiTenDangNhap = "";
		String loiMatKhau="";
		KhachHangDAO khDAO = new KhachHangDAO();
		if((khDAO.kiemTraKhachHang(tenDangNhap)) ) {
			loiTenDangNhap+= "Tên đăng nhập đã tồn tại, vui lòng nhập tên khác!";
			request.setAttribute("loiTenDangNhap", loiTenDangNhap);
			System.out.println("!OK");
		}
		else {		
			System.out.println("Ok");
			Random rd = new Random();
			String maKH = System.currentTimeMillis() + rd.nextInt(1000) + "";
			KhachHang khachHang = new KhachHang(maKH, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChiKhachHang, diaChiMuaHang, diaChiNhanHang,Date.valueOf(ngaySinh), dienThoai, email, dongYNhanMail != null) ;
			khDAO.insert(khachHang);
		}
		if(!matKhau.equals(matKhauNhapLai)) {
			loiMatKhau += "Mật khẩu không khớp, vui lòng nhập lại";
			request.setAttribute("loiMatKhau", loiMatKhau);
		}	
		
		String url= "khachhang/thanhcong.jsp";
		if(loiTenDangNhap.length()>0 || loiMatKhau.length()>0) {
			url = "/dangky.jsp";
		}
		RequestDispatcher rq = getServletContext().getRequestDispatcher(url);
		rq.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
