package domain.login;

public interface DriverDao {

	/**
	 * 
	 * @param c
	 * @return
	 */
	public int register(Driver c);
	
	/*
	 * Retrieve the Customer object from the database
	 */
	public Driver validateDriver(Login login);

	int passChange(Driver c);

	
	//public Customer getCustomer(String username, String pass); This method does not needed as we have the Login object

	
}