package modal;

import java.sql.Date;
import java.util.Objects;

public class TacGia {
	private String maTG;
	private String hoTen;
	private Date ngaySinh;
	private String tieuSu;
	public TacGia() {}
	public TacGia(String maTG, String hoTen, Date ngaySinh, String tieuSu) {
		this.maTG = maTG;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.tieuSu = tieuSu;
	}
	public String getMaTG() {
		return maTG;
	}
	public void setMaTG(String maTG) {
		this.maTG = maTG;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getTieuSu() {
		return tieuSu;
	}
	public void setTieuSu(String tieuSu) {
		this.tieuSu = tieuSu;
	}
	@Override
	public int hashCode() {
		return Objects.hash(hoTen, maTG, ngaySinh, tieuSu);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TacGia other = (TacGia) obj;
		return Objects.equals(hoTen, other.hoTen);
	}
	@Override
	public String toString() {
		return "TacGia [maTG=" + maTG + ", hoTen=" + hoTen + ", ngaySinh=" + ngaySinh + ", tieuSu=" + tieuSu + "]";
	}
	
	

	
}
