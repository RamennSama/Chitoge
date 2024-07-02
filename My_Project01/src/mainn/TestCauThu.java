package mainn;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.CauThu;
import work.CauThuFM;

public class TestCauThu {
	
	public static void Them(
			String id, 
			String name, 
			int age, 
			String birth, 
			String address, 
			String vi_tri) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
			java.util.Date utilDate = sdf.parse(birth);
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			
			CauThu Chitoge = new CauThu(id, name, age, sqlDate, address, vi_tri);
			CauThuFM.getIntance().Insert(Chitoge);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void capNhat(
			String id, 
			String name, 
			int age, 
			String birth, 
			String address, 
			String vi_tri) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
			java.util.Date utilDate = sdf.parse(birth);
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			
			CauThu Chitoge = new CauThu(id, name, age, sqlDate, address, vi_tri);
			CauThuFM.getIntance().Update(Chitoge);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void Xoa(String id) {
		CauThu Chito = new CauThu();
		Chito.setId(id);
		CauThuFM.getIntance().Delete(Chito);
	}
	
	public static void layTatCa() {
		ArrayList<CauThu> Chito = new ArrayList<CauThu>();
		Chito = CauThuFM.getIntance().selectAll();
		for(CauThu Data : Chito) {
			System.out.println(Data);
		}
	}
	
	public static void layId(String id) {
		CauThu Chito = new CauThu();
		Chito.setId(id);
		CauThu find = CauThuFM.getIntance().selectById(Chito);
		System.out.println(find);
	}
	
	public static void layCC(String con) {
		ArrayList<CauThu> Chito = CauThuFM.getIntance().selectByCondition(con);
		for(CauThu Data : Chito) {
			System.out.println(Data);
		}
	}
	public static void main(String[] args) {
		//Them("CT01", "Ronaldo", 39, "1985-02-05", "Portual", "ST");
		//capNhat("CT02", "Messi", 37, "1987-06-24", "Argentina", "ST");
		//Them("CT03", "cc", 38, "1986-06-24", "cali", "fandong");
		//Xoa("CT03");
		//layTatCa();
		layId("CT01");
		System.out.println("=====================================================");
		layCC("1=1");
	}
}
