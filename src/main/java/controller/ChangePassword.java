package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database_itf.KhachHangDAO;
import modal.KhachHang;
import util.MaHoa;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/change")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String matKhauHienTai = request.getParameter("matKhauHienTai");
		String matKhauMoi = request.getParameter("matKhauMoi");
		String matKhauMoiXacNhan = request.getParameter("matKhauMoiXacNhan");
		
		HttpSession session = request.getSession();
		Object  obj = session.getAttribute("khachHang");
		KhachHang khachHang = null;
		if(obj != null) {
			 khachHang = (KhachHang)obj;
		}
		String url = "/doimatkhau.jsp";
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
