package local;

public class Driver {
	private String name="Unclaimed";


	public Driver(String d) {
		if(d!=null)
			name=d;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
