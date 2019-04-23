package domain.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DbManager;



public class DriverDaolmpl implements DriverDao {

	static Connection conn;
	static PreparedStatement ps; 
	
	
	@Override
	public int passChange(Driver c) {
		try {
			
			conn = DbManager.getConnection();
			ps =conn.prepareStatement("Update Driver set password = ? where userId = ?");
			ps.setString(2, c.getUsername());
			ps.setString(1, c.getPassword());
			ps.executeUpdate();
			ps.close();
			conn.close();
			
			
		}catch(Exception e) {
			System.out.println("Help the thing failed");
		}
		
		return 1;
	}
	
	@Override
	public int register(Driver c) {
		int status = 0;
		try{
			conn = DbManager.getConnection();
			ps =conn.prepareStatement("insert into driver values(?,?,?)");
			ps.setString(1, c.getUsername());
			ps.setString(2, c.getPassword());
			ps.setString(3, c.getName());
			status = ps.executeUpdate();
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return status;
	}

	@Override
	public Driver validateDriver(Login login) {
		Driver d = null;
		try {
			conn = DbManager.getConnection();
			ps = conn.prepareStatement("select * from customer where userId=? and password=?");
			ps.setString(1, login.getUsername());
			ps.setString(2, login.getPassword());

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				 d = new Driver(rs.getString("userId"), rs.getString("password"), rs.getString("name"));
			} else
				return null;

			conn.close();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return d;
	}

}