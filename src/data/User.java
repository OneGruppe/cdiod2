package data;

public class User {

	private int id;
	private String name;
	
	public User(int id, String name){
		this.id = id;
		this.name = name;
	}

	protected int getId() {
		return id;
	}

	protected String getName() {
		return name;
	}
	
}
