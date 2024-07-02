package mainn;

import java.util.ArrayList;

import model.CauLacBo;
import work.CauLacBoFM;

public class TestCauLacBo {
	
	public static void Them(String id, String name, String country, String year, String coach) {
		CauLacBo Chito = new CauLacBo(id, name, country, year, coach);
		CauLacBoFM.getIntance().Insert(Chito);
	}
	
	public static void capNhat(String id, String name, String country, String year, String coach) {
		CauLacBo Chito = new CauLacBo(id, name, country, year, coach);
		CauLacBoFM.getIntance().Update(Chito);
	}
	
	public static void Xoa(String id) {
		CauLacBo Chito  = new CauLacBo();
		Chito.setId(id);
		CauLacBoFM.getIntance().Delete(Chito);
	}
	
	public static void layTatCa() {
		ArrayList<CauLacBo> Chito = null;
		Chito = CauLacBoFM.getIntance().selectAll();
		for(CauLacBo Data : Chito) {
			System.out.println(Data);
		}
	}
	
	public static void layId(String id) {
		CauLacBo Chito  = new CauLacBo();
		Chito.setId(id);
		CauLacBo Person = CauLacBoFM.getIntance().selectById(Chito);
		System.out.println(Person);
	}
	
	public static void layCC(String question) {
		ArrayList<CauLacBo> Chito = null;
		Chito = CauLacBoFM.getIntance().selectByCondition(question);
		for(CauLacBo data : Chito) {
			System.out.println(data);
		}
	}
	
	public static void main(String[] args) {
		//Them("CLB01", "Manchester United", "Enngland", "1878", "Tenhag");
		//Them("CLB02", "Manchester City", "Enngland", "1880", "PepTroc");
		//capNhat("CLB01", "Manchester United", "England", "1878", "Tenhag");
		//Xoa("CLB01");
		//layTatCa();
		//layId("CLB02");
		layCC("YEAR(YEAR) < 1880");
	}
}
