package modal;

import java.sql.Date;

import database_itf.KhachHangDAO;
import util.MaHoa;

public class KhachHang {
	private String maKhachHang;
	private String tenDangNhap;
	private String matKhau;
	private String hoTen;
	private String gioiTinh;
	private String diaChi;
	private String diaChiMua;
	private String diaChiNhan;
	private Date ngaySinh;
	private String soDT;
	private String email;	
	private boolean dangKiNhanBangTin;
	private String maXacThuc;
	private Date thoiGianHieuLuc;
	private boolean trangThaiXacThuc;
	public KhachHang() {}
	
	public KhachHang(String maKhachHang, String tenDangNhap, String matKhau, String hoTen, String gioiTinh,
			String diaChi, String diaChiMua, String diaChiNhan, Date ngaySinh, String soDT, String email,
			boolean dangKiNhanBangTin, String maXacThuc, Date thoiGianHieuLuc, boolean trangThaiXacThuc) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.diaChiMua = diaChiMua;
		this.diaChiNhan = diaChiNhan;
		this.ngaySinh = ngaySinh;
		this.soDT = soDT;
		this.email = email;
		this.dangKiNhanBangTin = dangKiNhanBangTin;
		this.maXacThuc = maXacThuc;
		this.thoiGianHieuLuc = thoiGianHieuLuc;
		this.trangThaiXacThuc = trangThaiXacThuc;
	}

	public KhachHang(String maKhachHang, String tenDangNhap, String matKhau, String hoTen, String gioiTinh, String diaChi, String diaChiMua, String diaChiNhan, Date ngaySinh, String soDT, String email, boolean dangKyNhanBangTin) {
		this.maKhachHang = maKhachHang;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.diaChiMua = diaChiMua;
		this.diaChiNhan = diaChiNhan;
		this.ngaySinh = ngaySinh;
		this.soDT = soDT;
		this.email = email;
		this.dangKiNhanBangTin = dangKyNhanBangTin;
	}
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getDiaChiMua() {
		return diaChiMua;
	}
	public void setDiaChiMua(String diaChiMua) {
		this.diaChiMua = diaChiMua;
	}
	public String getDiaChiNhan() {
		return diaChiNhan;
	}
	public void setDiaChiNhan(String diaChiNhan) {
		this.diaChiNhan = diaChiNhan;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getSoDT() {
		return soDT;
	}
	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isDangKiNhanBangTin() {
		return dangKiNhanBangTin;
	}
	public void setDangKiNhanBangTin(boolean dangKiNhanBangTin) {
		this.dangKiNhanBangTin = dangKiNhanBangTin;
	}
	
	
	public String getMaXacThuc() {
		return maXacThuc;
	}

	public void setMaXacThuc(String maXacThuc) {
		this.maXacThuc = maXacThuc;
	}

	public Date getThoiGianHieuLuc() {
		return thoiGianHieuLuc;
	}

	public void setThoiGianHieuLuc(Date thoiGianHieuLuc) {
		this.thoiGianHieuLuc = thoiGianHieuLuc;
	}

	public boolean isTrangThaiXacThuc() {
		return trangThaiXacThuc;
	}

	public void setTrangThaiXacThuc(boolean trangThaiXacThuc) {
		this.trangThaiXacThuc = trangThaiXacThuc;
	}

	
	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau
				+ ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", diaChiMua=" + diaChiMua
				+ ", diaChiNhan=" + diaChiNhan + ", ngaySinh=" + ngaySinh + ", soDT=" + soDT + ", email=" + email
				+ ", dangKiNhanBangTin=" + dangKiNhanBangTin + ", maXacThuc=" + maXacThuc + ", thoiGianHieuLuc="
				+ thoiGianHieuLuc + ", trangThaiXacThuc=" + trangThaiXacThuc + "]";
	}

	public static void main(String[] args) {
//		KhachHangDAO khDAO = new KhachHangDAO();
//		KhachHang kh = new KhachHang();
//		String user = "danh1234";
//		String mk = "1234";
//		mk = MaHoa.Encode(mk);
//		kh.setTenDangNhap(user);
//		kh.setMatKhau(mk);
//		KhachHang khachHang = khDAO.selectUser(kh);
//		if(khachHang!= null && khachHang.isTrangThaiXacThuc()) {
//			System.out.println("Ok");
//		}
//		else {
//			System.out.println("Ko Ok");
//		}
	}
	
	
}
