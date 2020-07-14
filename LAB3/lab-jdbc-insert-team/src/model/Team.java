package model;

public class Team
{
	
	String name;
	String coach;
	String captain;
	City city;
	long id;
	
	public Team(String name, String coach, String captain, City city,long id) {
		super();
		this.name = name;
		this.coach = coach;
		this.captain = captain;
		this.city = city;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCoach() {
		return coach;
	}
	public void setCoach(String coach) {
		this.coach = coach;
	}
	public String getCaptain() {
		return captain;
	}
	public void setCaptain(String captain) {
		this.captain = captain;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	
	
}
