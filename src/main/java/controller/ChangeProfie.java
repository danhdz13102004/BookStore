package controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database_itf.KhachHangDAO;
import modal.KhachHang;

/**
 * Servlet implementation class ChangeProfie
 */
@WebServlet("/thay-doi-thong-tin")
public class ChangeProfie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeProfie() {
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
		// TODO Auto-generated method stub
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
				url = "/thaydoithongtin.jsp";
				request.setAttribute("baoLoi", "Thay đổi không thành công");
			} 
			HttpSession session = request.getSession();
			session.setAttribute("khachHang", kh2);
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
