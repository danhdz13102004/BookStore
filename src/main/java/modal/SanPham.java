package modal;

public class SanPham {
	private String maSanPham;
	private String tenSanPham;
	private TacGia tacGia;
	private int namXuatBan;
	private double giaNhap;
	private double giaGoc;
	private double giaBan;
	private double soLuong;
	private TheLoai theLoai;
	private String ngonNgu;
	private String moTa;
	public SanPham() {
	}
	public SanPham(String maSanPham, String tenSanPham, TacGia tacGia, int namXuatBan, Double giaNhap, Double giaGoc,
			Double giaBan, double soLuong, TheLoai theLoai, String ngonNgu, String moTa) {
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.tacGia = tacGia;
		this.namXuatBan = namXuatBan;
		this.giaNhap = giaNhap;
		this.giaGoc = giaGoc;
		this.giaBan = giaBan;
		this.soLuong = soLuong;
		this.theLoai = theLoai;
		this.ngonNgu = ngonNgu;
		this.moTa = moTa;
	}
	public String getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public TacGia getTacGia() {
		return tacGia;
	}
	public void setTacGia(TacGia tacGia) {
		this.tacGia = tacGia;
	}
	public int getNamXuatBan() {
		return namXuatBan;
	}
	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}
	public Double getGiaNhap() {
		return giaNhap;
	}
	public void setGiaNhap(Double giaNhap) {
		this.giaNhap = giaNhap;
	}
	public Double getGiaGoc() {
		return giaGoc;
	}
	public void setGiaGoc(Double giaGoc) {
		this.giaGoc = giaGoc;
	}
	public Double getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(Double giaBan) {
		this.giaBan = giaBan;
	}
	public double getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public TheLoai getTheLoai() {
		return theLoai;
	}
	public void setTheLoai(TheLoai theLoai) {
		this.theLoai = theLoai;
	}
	public String getNgonNgu() {
		return ngonNgu;
	}
	public void setNgonNgu(String ngonNgu) {
		this.ngonNgu = ngonNgu;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	
	
	
}
