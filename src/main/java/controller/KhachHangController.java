package controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.Calendar;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database_itf.KhachHangDAO;
import modal.KhachHang;
import util.Email;
import util.MaHoa;
import util.RandomNumber;

/**
 * Servlet implementation class KhachHangController
 */
@WebServlet("/khach-hang")
public class KhachHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KhachHangController() {
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
		String hanhDong = request.getParameter("hanhDong");
		if(hanhDong.equals("dang-nhap")) {
			dangNhap(request, response);
		}
		else if(hanhDong.equals("dang-xuat")) {
			dangXuat(request, response);
		}
		else if(hanhDong.equals("dang-ky")) {
			dangKy(request, response);
		}
		else if(hanhDong.equals("doi-mat-khau")) {
			doiMatKhau(request, response);
		}
		else if(hanhDong.equals("thay-doi-thong-tin")) {
			doiThongTin(request, response);
		}
		else if(hanhDong.equals("xac-thuc")) {
			xacThuc(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void dangKy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			String url= "/khachhang/thanhcong.jsp";
			KhachHangDAO khDAO = new KhachHangDAO();
			if((khDAO.kiemTraKhachHang(tenDangNhap)) ) {
				loiTenDangNhap+= "Tên đăng nhập đã tồn tại, vui lòng nhập tên khác!";
				request.setAttribute("loiTenDangNhap", loiTenDangNhap);
				System.out.println("!OK");
				url = "/khachhang/dangky.jsp";
			}
			if(!matKhau.equals(matKhauNhapLai)) {
				loiMatKhau += "Mật khẩu không khớp, vui lòng nhập lại";
				request.setAttribute("loiMatKhau", loiMatKhau);
				url = "/khachhang/dangky.jsp";
			}	
			if(loiTenDangNhap.length()==0 && loiMatKhau.length()==0) {
				Random rd =new Random();
				System.out.println("Ok");
				String maKH = System.currentTimeMillis() + rd.nextInt(1000) + "";
				KhachHang khachHang = new KhachHang(maKH, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChiKhachHang, diaChiMuaHang, diaChiNhanHang,Date.valueOf(ngaySinh), dienThoai, email, dongYNhanMail != null) ;
				if(khDAO.insert(khachHang) > 0) {
					String maXacThuc = RandomNumber.getNumber();
					
					Date todaysDate = new Date(new java.util.Date().getTime());
					Calendar c = Calendar.getInstance();
					c.setTime(todaysDate);
					c.add(Calendar.DATE, 1);
					Date thoiGianHieuLuc = new Date(c.getTimeInMillis());
					
					boolean trangThaiXacThuc = false;
					
					khachHang.setMaXacThuc(maXacThuc);
					khachHang.setThoiGianHieuLuc(thoiGianHieuLuc);
					khachHang.setTrangThaiXacThuc(trangThaiXacThuc);
					if(khDAO.updateVerifyInfor(khachHang) > 0) {
					Email.sendEmail(khachHang.getEmail(), "Email xac thuc tai khoan", getNoiDung(khachHang));
					} 
				} 
			}
			RequestDispatcher rq = getServletContext().getRequestDispatcher(url);
			rq.forward(request, response);
	}
	
	protected void dangNhap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			String tenDangNhap = request.getParameter("tenDangNhap");
			String matKhau = request.getParameter("matKhau");
			matKhau = MaHoa.Encode(matKhau);
			
			KhachHang kh = new KhachHang();
			kh.setTenDangNhap(tenDangNhap);
			kh.setMatKhau(matKhau);
			System.out.println(tenDangNhap);
			System.out.println(matKhau);
			
			KhachHangDAO khDAO = new KhachHangDAO();
			KhachHang khachHang = khDAO.selectUser(kh);
			System.out.println(khachHang.toString());
			String url ="";
			if(khachHang != null && khachHang.isTrangThaiXacThuc()) {
				HttpSession session = request.getSession();
				session.setAttribute("khachHang", khachHang);
				url = "/index.jsp";
			}
			else if(khachHang != null && khachHang.isTrangThaiXacThuc()==false) {
				request.setAttribute("baoLoi","Tài khoản của bạn chưa được xác thực, vui lòng kiểm tra lại email" );
				url = "/khachhang/dangnhap.jsp";
			}
			else {
				request.setAttribute("baoLoi","Tên đăng nhập hoặc mật khẩu không chính xác" );
				request.setAttribute("tenDangNhap",tenDangNhap);
				url = "/khachhang/dangnhap.jsp";
			}
			RequestDispatcher rq = getServletContext().getRequestDispatcher(url);
			rq.forward(request, response);
	}
	
	protected void dangXuat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			session.invalidate();
			String url = request.getScheme() + "://" + request.getServerName()+ ":" + request.getServerPort() + request.getContextPath();
			response.sendRedirect(url + "/index.jsp");
	}
	protected void doiMatKhau(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String matKhauHienTai = request.getParameter("matKhauHienTai");
			String matKhauMoi = request.getParameter("matKhauMoi");
			String matKhauMoiXacNhan = request.getParameter("matKhauMoiXacNhan");
			
			HttpSession session = request.getSession();
			Object  obj = session.getAttribute("khachHang");
			KhachHang khachHang = null;
			if(obj != null) {
				 khachHang = (KhachHang)obj;
			}
			String url = "/khachhang/doimatkhau.jsp";
			String baoLoi = "";
			matKhauHienTai = MaHoa.Encode(matKhauHienTai);
			if(!matKhauHienTai.equals(khachHang.getMatKhau())) {
				baoLoi += "Mật khẩu hiện tại không chính xác!";
			}
			else {
				if(!matKhauMoi.equals(matKhauMoiXacNhan)) {
					baoLoi += "Mật khẩu nhập lại không khớp!";
				}
				else {
					KhachHangDAO khDAO = new KhachHangDAO();
					matKhauMoi = MaHoa.Encode(matKhauMoi);
					if(khDAO.changePass(khachHang, matKhauMoi)) {
						baoLoi += "Thay đổi mật khẩu thành công";
						url = "/index.jsp";
					}
					else {
						baoLoi += "Có lỗi trong quá trình thay đổi mật khẩu";
					}
				}
			}
			request.setAttribute("baoLoi", baoLoi);
			RequestDispatcher rq = getServletContext().getRequestDispatcher(url);
			rq.forward(request, response);
	}
	
	protected void doiThongTin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String tenKhachHang = request.getParameter("hoVaTen");
			String gioiTinh = request.getParameter("gioiTinh");
			String ngaySinh = request.getParameter("ngaySinh");
			String diaChiKhachHang = request.getParameter("diaChiKhachHang");
			String diaChiMuaHang = request.getParameter("diaChiMuaHang");
			String diaChiNhanHang = request.getParameter("diaChiNhanHang");
			String dienThoai = request.getParameter("dienThoai");
			String email = request.getParameter("email");
			String dongYNhanMail = request.getParameter("dongYNhanMail");
			tenKhachHang = getUTF8(tenKhachHang);
			diaChiKhachHang = getUTF8(diaChiKhachHang);
			diaChiMuaHang = getUTF8(diaChiMuaHang);
			diaChiNhanHang = getUTF8(diaChiNhanHang);
			
			Object obj = request.getSession().getAttribute("khachHang");
			KhachHang kh1 = null;
			String url ="/index.jsp";
			if (obj!=null) {
				kh1 = (KhachHang)obj;
				KhachHang kh2 = new KhachHang(kh1.getMaKhachHang(),kh1.getTenDangNhap(),kh1.getMatKhau(),tenKhachHang,gioiTinh,diaChiKhachHang,diaChiMuaHang,diaChiNhanHang,Date.valueOf(ngaySinh),dienThoai,email,dongYNhanMail!=null);
				KhachHangDAO khDAO = new KhachHangDAO();
				if(khDAO.update(kh2) == 0 ) {
					url = "/khachhang/thaydoithongtin.jsp";
					request.setAttribute("baoLoi", "Thay đổi không thành công");
				} 
				HttpSession session = request.getSession();
				session.setAttribute("khachHang", kh2);
			}
			RequestDispatcher rq = getServletContext().getRequestDispatcher(url);
			rq.forward(request, response);	
	}
	protected void xacThuc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maKhachHang = request.getParameter("maKhachHang");
		String maXacThuc = request.getParameter("maXacThuc");
		KhachHangDAO khDAO = new KhachHangDAO();
		KhachHang khachHang = new KhachHang();
		khachHang.setMaKhachHang(maKhachHang);
		KhachHang kh = khDAO.selectById(khachHang);
		kh.setTrangThaiXacThuc(true);
		khDAO.updateVerifyInfor(kh);
		
		String url = "/khachhang/dangnhap.jsp";
		request.setAttribute("thanhCong", "Bạn đã xác thực thành công, vui lòng đăng nhập để tiếp tục");
		RequestDispatcher rq = getServletContext().getRequestDispatcher(url);
		rq.forward(request, response);
		
	}
	public static String getNoiDung(KhachHang kh) {
		String link = "http://localhost:8080/MyProject/khach-hang?hanhDong=xac-thuc&maKhachHang=" + kh.getMaKhachHang() + "&maXacThuc=" + kh.getMaXacThuc();
		String ND = "<p style=\"text-align: center;\">Xin ch&agrave;o "+ kh.getHoTen() + "</p>\r\n"
				+ "<p>Đ&acirc;y l&agrave; m&atilde; x&aacute;c thực của bạn : <span style=\"color: #ffffff; background-color: #003300;\"> "+ kh.getMaXacThuc() + "&nbsp;&nbsp;</span></p>\r\n"
				+ "<p>Vui l&ograve;ng nhập m&atilde; x&aacute;c nhận để ho&agrave;n th&agrave;nh việc đăng k&iacute; hoặc nhấn v&agrave;o đường link dưới đ&acirc;y:</p>\r\n"
				+ "<p><a href=\""+ link +"\"> "+ link +" </a></p>";
		return ND;
	}
	
	

}
