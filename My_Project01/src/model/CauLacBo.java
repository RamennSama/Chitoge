package model;

public class CauLacBo {
	private String id, name, country, year, coach;
	
	public CauLacBo(){
		super();
	}
	
	public CauLacBo(String id, String name, String country, String year, String coach) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.year = year;
		this.coach = coach;
	}
	
	@Override
	public String toString() {
		return "CauLacBo [id=" + id + ", name=" + name + ", country=" + country + ", year=" + year + ", coach=" + coach
				+ "]";
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}
	
}
