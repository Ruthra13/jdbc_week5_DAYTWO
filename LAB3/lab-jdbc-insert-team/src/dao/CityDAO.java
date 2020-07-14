package dao;

import utility.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.City;

//1.Create a dao-class called as CityDA0 with below methods- public City getCityByName(String name) 
//- Method to fetch the city information from database based on the city name.- public createCity()- which takes the city class as argument


public class CityDAO

{
	
	ConnectionManager cm = new ConnectionManager();
	
	public City getCityByName(String name) throws SQLException, Exception
	{
		
		City city = null;
		
		
		String sql =  "SELECT ID FROM CITY WHERE NAME = '"+name+"'";
		
		PreparedStatement st = cm.getConnection().prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next())
		{
			city.setCityId(rs.getLong("ID"));
		}
		
		cm.getConnection().close();
		
		return city;
		
	}
	
public void createCity(City city) throws SQLException, Exception
{
	String cityname = city.getCityName();
	long id = city.getCityId();
	
	String sql = "insert into CITY(ID,NAME)VALUES(?,?)";
	
	PreparedStatement st = cm.getConnection().prepareStatement(sql);
	
	st.setString(1, cityname);
	st.setLong(2,id);
	
	st.executeUpdate();
	
	
	cm.getConnection().close();
	
}



}
