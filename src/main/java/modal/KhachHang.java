package modal;

import java.sql.Date;

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
	public KhachHang() {}
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
	public static void main(String[] args) {
		
	}
	
	
}
