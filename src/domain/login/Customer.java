package domain.login;

/**
 * 
 * @author mehra
 *
 */
public class Customer extends User {

	public Customer(String username, String password, String name) {
		super(username, password, name);
	}

	public boolean Validate(Login login) {
		System.out.printf("Login: %s, %s\n", login.getUsername(), login.getPassword());
		System.out.printf("Customer: %s, %s\n", username, password);

		if (!this.username.equals(login.getUsername())) {
			return false;
		}
		if (!this.password.equals(login.getPassword())) {
			return false;
		}

		return true;

	}

}
