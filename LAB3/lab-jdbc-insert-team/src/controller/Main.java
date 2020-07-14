package controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import dao.*;
import model.City;
import model.Team;

//1.Create a main-class called Main inside the controller package.
//2.Create appropriate objects for the TeamDAO and CityDAO class.
//3.Create appropriate objects for the model classes.
//4.Get the values from main class and pass to the createTeam method to store in the database.
//5.Call the getCityByName method and display the details of the players.

public class Main
{
	public static void main(String[] args) throws Exception
	{
		TeamDAO teamdao = new TeamDAO();
		CityDAO citydao = new CityDAO();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the team id");
		int id = Integer.parseInt(br.readLine());
		System.out.println("Enter team name ");
		String teamname = br.readLine();
		System.out.println("Enter coach name");
		String coachname = br.readLine();
		System.out.println("Enter the captain name");
		String captain = br.readLine();
		System.out.println("Enter the city");
		String cityname = br.readLine();
		City  city = new City(0,cityname);
		Team team = new Team(teamname,coachname,captain,city,id);
		teamdao.createTeam(team);
		city = citydao.getCityByName(cityname);
		System.out.println("Team Details are : ");
		teamdao.displayPlayerDetails(city.getCityId());
		
	}
}
