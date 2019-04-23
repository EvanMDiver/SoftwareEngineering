package domain.login;

public class Driver extends User {

	public Driver(String username, String password, String name) {
		super(username, password, name); 
	}
	
	public boolean Validate(Login login) {
		if (!this.username.equals(login.getUsername())) {
			return false;
		}
		if (!this.password.equals(login.getPassword())) {
			return false;
		}

		return true;

	}

} 
