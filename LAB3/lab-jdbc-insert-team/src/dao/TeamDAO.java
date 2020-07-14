package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.City;
import model.Team;
import utility.ConnectionManager;

public class TeamDAO
{
	ConnectionManager cm = new ConnectionManager();
	 public void createTeam(Team team) throws Exception
	 {
		 long id = team.getId();
		 String name = team.getName();
		 String coach = team.getCoach();
		 String captain = team.getCaptain();
		 City city = team.getCity();
		 long cityid = city.getCityId();
			
			String sql = "insert into TEAM(ID,NAME,COACH,HOME_CITY_ID,CAPTAIN)VALUES(?,?,?,?,?)";
			
			PreparedStatement st = cm.getConnection().prepareStatement(sql);
			
			st.setLong(1, id);
			st.setString(2,name);
			st.setString(3, coach);
			st.setLong(4,cityid);
			st.setString(5,captain);
			
			st.executeUpdate();
			
			
			cm.getConnection().close();
	 }
	 
	 public void displayPlayerDetails(long cityId) throws Exception {
		 	
			
			String sql = "SELECT * FROM PLAYER WHERE TEAM_ID IN (SELECT ID FROM TEAM WHERE HOME_CITY_ID = "+ cityId + ")";
			
			PreparedStatement st = cm.getConnection().prepareStatement(sql);
	
			st.executeQuery();
			
			cm.getConnection().close();
	 }
}
