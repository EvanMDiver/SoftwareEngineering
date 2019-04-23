package domain.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DbManager;



public class DriverDaolmpl implements DriverDao {

	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();
	
	
	@Override
	public int passChange(Driver c) {
		try {
			
			conn = db.getConnection();
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
			conn = db.getConnection();
			ps =conn.prepareStatement("insert into Driver values(?,?,?)");
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
		Driver c = new Driver();
		try{
			conn = db.getConnection();
			ps =conn.prepareStatement("select * from Driver where userId=? and password=?");
			ps.setString(1, login.getUsername());
			ps.setString(2, login.getPassword());

			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				c.setUsername(rs.getString(1));
				c.setPassword(rs.getString(2));
				c.setName(rs.getString(3));
			}
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return c;
	}

}