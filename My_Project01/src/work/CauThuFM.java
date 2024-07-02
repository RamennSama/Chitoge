package work;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.Cheems_cnt;
import model.CauThu;

public class CauThuFM implements Cheems_format<CauThu>{
	
	public static CauThuFM getIntance() {
		return new CauThuFM();
	}

	@Override
	public int Insert(CauThu t) {
		int ketQua = 0;
		Connection cnt = Cheems_cnt.getConnection();
		String sql = "INSERT INTO CauThu " + "VALUES(?,?,?,?,?,?)";
		PreparedStatement st;
		try {
			st = cnt.prepareStatement(sql);
			st.setString(1, t.getId());
			st.setString(2, t.getName());
			st.setInt(3, t.getAge());
			st.setDate(4, t.getBirth());
			st.setString(5, t.getAddress());
			st.setString(6, t.getViTri());
			ketQua = st.executeUpdate();
			System.out.println("Bạn đã thực thi : " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi");
			Cheems_cnt.closeConnection(cnt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int Update(CauThu t) {
		int ketQua = 0;
		Connection cnt = Cheems_cnt.getConnection();
		String sql = "UPDATE CauThu " + 
		             "SET " + 
				     "NAME = ?" + ",AGE = ?" + ",BIRTH = ?" + ",ADDRESS = ?" + ",VI_TRI = ?" + 
		             "WHERE ID = ?";
		try {
			PreparedStatement st = cnt.prepareStatement(sql);
			st.setString(1, t.getName());
			st.setInt(2, t.getAge());
			st.setDate(3, t.getBirth());
			st.setString(4, t.getAddress());
			st.setString(5, t.getViTri());
			st.setString(6, t.getId());
			ketQua = st.executeUpdate();
			System.out.println("Bạn đã thực thi : " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi");
			Cheems_cnt.closeConnection(cnt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int Delete(CauThu t) {
		int ketQua = 0;
		Connection cnt = Cheems_cnt.getConnection();
		String sql = "DELETE FROM CauThu " + 
		             "WHERE ID = ?";
		try {
			PreparedStatement st = cnt.prepareStatement(sql);
			st.setString(1, t.getId());
			ketQua = st.executeUpdate();
			System.out.println("Bạn đã thực thi : " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi");
			Cheems_cnt.closeConnection(cnt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public ArrayList<CauThu> selectAll() {
		ArrayList<CauThu> ketQua = new ArrayList<CauThu>();
		Connection cnt = Cheems_cnt.getConnection();
		String sql = "SELECT * " + "FROM CauThu";
		try {
			PreparedStatement st = cnt.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");
				Date birth = rs.getDate("BIRTH");
				String address = rs.getString("ADDRESS");
				String vi_tri  = rs.getString("VI_TRI");
				CauThu cc = new CauThu(id, name, age, birth, address, vi_tri);
				ketQua.add(cc);
			}
			System.out.println("Bạn đã thực thi : " + sql);
			Cheems_cnt.closeConnection(cnt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}
	
	@Override
	public CauThu selectById(CauThu t) {
		CauThu ketQua = null;
		Connection cnt = Cheems_cnt.getConnection();
		String sql = "SELECT * " + "FROM CauThu " + "WHERE ID = ?";
		PreparedStatement st;
		try {
			st = cnt.prepareStatement(sql);
			st.setString(1, t.getId());
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");
				Date birth = rs.getDate("BIRTH");
				String address = rs.getString("ADDRESS");
				String vi_tri  = rs.getString("VI_TRI");
				ketQua = new CauThu(id, name, age, birth, address, vi_tri);
			}
			System.out.println("Bạn đã thực thi : " + sql);
			Cheems_cnt.closeConnection(cnt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public ArrayList<CauThu> selectByCondition(String Condition) {
		ArrayList<CauThu> ketQua = new ArrayList<CauThu>();
		Connection cnt = Cheems_cnt.getConnection();
		String sql = "SELECT * " + "FROM CauThu " + "WHERE " + Condition;
		try {
			PreparedStatement st = cnt.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");
				Date birth = rs.getDate("BIRTH");
				String address = rs.getString("ADDRESS");
				String vi_tri  = rs.getString("VI_TRI");
				CauThu cc = new CauThu(id, name, age, birth, address, vi_tri);
				ketQua.add(cc);
			}
			System.out.println("Bạn đã thực thi : " + sql);
			Cheems_cnt.closeConnection(cnt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

}
