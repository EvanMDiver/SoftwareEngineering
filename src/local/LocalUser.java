package local;

import domain.login.User;

public class LocalUser {
	
	private String username = null;
	private String pass = null;
	private String name = null;
	private static LocalUser instance=null;
	private static User user;
	
	private LocalUser() {}
	
	public static LocalUser getInstance() {
		if(instance==null)
			instance=new LocalUser();
		return instance;
	}

	public void setUser(User u) {
		this.user = u;
	}
	
	public static User getUser() {
		return user;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}