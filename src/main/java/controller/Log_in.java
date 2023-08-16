package controller;

import java.io.IOException;

import util.*;

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
 * Servlet implementation class Log_in
 */
@WebServlet("/log-in")
public class Log_in extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Log_in() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		String url ="";
		if(khachHang != null) {
			HttpSession session = request.getSession();
			session.setAttribute("khachHang", khachHang);
			url = "/index.jsp";
		}else {
			request.setAttribute("baoLoi","Tên đăng nhập hoặc mật khẩu không chính xác" );
			request.setAttribute("tenDangNhap",tenDangNhap);
			url = "/dangnhap.jsp";
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
