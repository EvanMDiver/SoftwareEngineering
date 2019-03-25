package local;

public class LocalUser {
	
	private String username = null;
	private String pass = null;
	private String name = null;
	private static LocalUser instance=null;
	
	private LocalUser() {}
	
	public static LocalUser getInstance() {
		if(instance==null)
			instance=new LocalUser();
		return instance;
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