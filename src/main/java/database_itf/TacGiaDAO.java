package database_itf;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;

import modal.TacGia;

public class TacGiaDAO implements InterfaceDAO<TacGia>{
	private ArrayList<TacGia> data;
	@Override
	public ArrayList<TacGia> selectAll() {
		ArrayList<TacGia> ketQua = new ArrayList<TacGia>();
		try {
			Connection con =  (Connection) JDBCUtil.getConnection();
			String sql = "select * from tacgia";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				String maTacGia = res.getString(1);
				String tenTG = res.getString(2);
				Date ngaySinh = res.getDate(3);
				String tieuSu = res.getString(4);
				TacGia tg = new TacGia(maTacGia, tenTG, ngaySinh, tieuSu);
				ketQua.add(tg);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public TacGia selectById(TacGia t) {
		TacGia tg = null;
		try {
			Connection con = (Connection) JDBCUtil.getConnection();
			String sql = "select * from tacgia where matacgia = ?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1,t.getMaTG());
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				 tg = new TacGia(res.getString(1), res.getString(2), res.getDate(3), res.getString(4));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return tg;
	}

	@Override
	public int insert(TacGia t) {
		TacGia tg_find = this.selectById(t);
		if(tg_find == null) {
			try {
				Connection con = (Connection) JDBCUtil.getConnection();
				String sql = "insert into tacgia value \r\n"
						+ "(?,?,?,?)";
				PreparedStatement ps = (PreparedStatement)con.prepareStatement(sql);
				ps.setString(1,t.getMaTG());
				ps.setString(2,t.getHoTen());
				ps.setDate(3,t.getNgaySinh());
				ps.setString(4,t.getTieuSu());
				System.out.println(t.toString());
				return ps.executeUpdate();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<TacGia> arr) {
		int cnt=0;
		for(TacGia tg : arr) {
			cnt += insert(tg);
		}
		return cnt;
	}

	@Override
	public int delete(TacGia t) {
		TacGia tg_find = this.selectById(t);
		if(tg_find != null) {
			try {
				Connection con = (Connection) JDBCUtil.getConnection();
				String sql = "delete from tacgia\r\n"
						+ "where matacgia = ?";
				PreparedStatement ps = (PreparedStatement)con.prepareStatement(sql);
				ps.setString(1,t.getMaTG());
				return ps.executeUpdate();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<TacGia> arr) {
		int cnt=0;
		for(TacGia tg : arr) {
			cnt += this.delete(tg);
		}
		return cnt;
	}

	@Override
	public int update(TacGia t) {
		try {
			Connection con = (Connection)JDBCUtil.getConnection();
			String sql = "update tacgia set\r\n"
					+ "hovaten = ?, ngaysinh = ?, tieusu = ?\r\n"
					+ "where matacgia = ?";
			PreparedStatement ps = (PreparedStatement)con.prepareStatement(sql);
			ps.setString(1,t.getHoTen());
			ps.setDate(2,t.getNgaySinh());
			ps.setString(3,t.getTieuSu());
			ps.setString(4, t.getMaTG());
			return ps.executeUpdate();		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public static void main(String[] args) {
		TacGiaDAO tgDAO = new TacGiaDAO();
//		ArrayList<TacGia> arr = tgDAO.selectAll();
//		for(TacGia tg : arr) {
//			System.out.println(tg.toString());
//		}
		@SuppressWarnings("deprecation")
		TacGia tg = new TacGia("TG04", null,null,"Ä�Ã£ bá»‹ thay Ä‘á»•i rá»“i nhaa!");
		System.out.println(tgDAO.update(tg));
	}
}
