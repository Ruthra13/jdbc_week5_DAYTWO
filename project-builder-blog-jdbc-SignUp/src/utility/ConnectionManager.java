
package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;

import java.io.InputStream;

public class ConnectionManager {
	
	
	public static Properties loadPropertiesFile() throws Exception {
		Properties prop = new Properties();	
		InputStream in = (InputStream) ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		prop.load(in);
		in.close(); 
		return prop;
	}
	
	
	public static  Connection getConnection() throws Exception
	{
		Properties prop = null;
		prop = loadPropertiesFile();
		
		final String driver = prop.getProperty("driver");
		final String url = prop.getProperty("url");
		final String username = prop.getProperty("username");
		final String password = prop.getProperty("password");
		
		Class.forName(driver);
		Connection con = null;
		con = DriverManager.getConnection(url, username, password);
		
		if(con!=null)
			return con;
		else
			return null;
	}
	
	
	
}
