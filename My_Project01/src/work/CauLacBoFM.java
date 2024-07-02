package work;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.Cheems_cnt;
import model.CauLacBo;

public class CauLacBoFM implements Cheems_format<CauLacBo>{
	
	public static CauLacBoFM getIntance() {
		return new CauLacBoFM();
	}

	@Override
	public int Insert(CauLacBo t) {
		int ketQua = 0;
		Connection cnt = Cheems_cnt.getConnection();
		String sql = "INSERT INTO CauLacBo " + " VALUES(?,?,?,?,?)";
		try {
			PreparedStatement st = cnt.prepareStatement(sql);
			st.setString(1, t.getId());
			st.setString(2, t.getName());
			st.setString(3, t.getCountry());
			st.setString(4, t.getYear());
			st.setString(5, t.getCoach());
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
	public int Update(CauLacBo t) {
		int ketQua = 0;
		Connection cnt = Cheems_cnt.getConnection();
		String sql = "UPDATE CauLacBo " + "SET " +
		                                  "NAME = ?" + ",COUNTRY = ?" + ",YEAR = ?" +
				                          ",COACH = ?" + " WHERE ID = ?";
		try {
			PreparedStatement st = cnt.prepareStatement(sql);
			st.setString(1, t.getName());
			st.setString(2, t.getCountry());
			st.setString(3, t.getYear());
			st.setString(4, t.getCoach());
			st.setString(5, t.getId());
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
	public int Delete(CauLacBo t) {
		int ketQua = 0;
		Connection cnt = Cheems_cnt.getConnection();
		String sql = "DELETE FROM CauLacBo " + " WHERE ID = ?";
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
	public ArrayList<CauLacBo> selectAll() {
		ArrayList<CauLacBo> ketQua = new ArrayList<CauLacBo>();
		Connection cnt = Cheems_cnt.getConnection();
		String sql = "SELECT * " + "FROM CauLacBo";
		try {
			PreparedStatement st = cnt.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				String country = rs.getString("COUNTRY");
				String year = rs.getString("YEAR");
				String coach = rs.getString("COACH");
				CauLacBo cc = new CauLacBo(id, name, country, year, coach);
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
	public CauLacBo selectById(CauLacBo t) {
		CauLacBo ketQua = null;
		Connection cnt = Cheems_cnt.getConnection();
		String sql = "SELECT * " + "FROM CauLacBo " + " WHERE ID = ?";
		try {
			PreparedStatement st = cnt.prepareStatement(sql);
			st.setString(1, t.getId());
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				String country = rs.getString("COUNTRY");
				String year = rs.getString("YEAR");
				String coach = rs.getString("COACH");
				CauLacBo cc = new CauLacBo(id, name, country, year, coach);
				ketQua = cc;
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
	public ArrayList<CauLacBo> selectByCondition(String Condition) {
		ArrayList<CauLacBo> ketQua = new ArrayList<CauLacBo>();
		Connection cnt = Cheems_cnt.getConnection();
		String sql = "SELECT * " + "FROM CauLacBo " + "WHERE " + Condition;
		try {
			PreparedStatement st = cnt.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				String country = rs.getString("COUNTRY");
				String year = rs.getString("YEAR");
				String coach = rs.getString("COACH");
				CauLacBo cc = new CauLacBo(id, name, country, year, coach);
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
