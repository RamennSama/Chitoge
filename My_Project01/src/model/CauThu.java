package model;

import java.sql.Date;

public class CauThu {
	private String id, name;
	private int age;
	private Date birth;
	private String address, viTri;
	
	public CauThu(){
		super();
	}

	public CauThu(String id, String name, int age, Date birth, String address, String viTri) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.birth = birth;
		this.address = address;
		this.viTri = viTri;
	}

	@Override
	public String toString() {
		return "CauThu [id=" + id + ", name=" + name + ", age=" + age + ", birth=" + birth + ", address=" + address
				+ ", viTri=" + viTri + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getViTri() {
		return viTri;
	}

	public void setViTri(String viTri) {
		this.viTri = viTri;
	}

}
