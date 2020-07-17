package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import utility.ConnectionManager;


public class UserDAO
{
	public int signUp(User user) throws SQLException, Exception
	{
		int result;
		final String sql = "insert into user (email,password,date) values (?,?,?)";
		
		PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(sql);
		
		ps.setString(1,user.getEmail());
		ps.setString(2,user.getPassword());
		ps.setDate(3,java.sql.Date.valueOf(user.getDate()) );
		result = ps.executeUpdate();
		
		return result;
	}
	
	
	public boolean loginUser(User user) throws SQLException, Exception
	{
		final String sql = "Select * from user";
		String email = user.getEmail();
		String password = user.getPassword();
		int flag = 0;
		
		PreparedStatement st = ConnectionManager.getConnection().prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next())
		{
			String email_db = rs.getString("email");
			String password_db = rs.getString("password");
			
			if ((email.equals(email_db)) && (password.equals(password_db))  )
					{
						flag = 1;
				
					}
			
			else
				flag = 0;
			
		}
		if(flag == 1)
		return true;
		else
			return false;
	}
	
	
	
}
