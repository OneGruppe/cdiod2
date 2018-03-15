package data;

/**
 * User class last edited 11.03.2018 - 03.34
 * @author Group 12
 *  
 */

public class User {

	private int id;
	private String name;

	/**
	 * Konstruktør for User objekt med ID og navn
	 * @param id ID til brugeren
	 * @param name Navnet på brugeren
	 */
	public User(int id, String name){
		this.id = id;
		this.name = name;
	}

	/**
	 * Getter til ID på brugeren
	 * @return ID på brugeren
	 */
	public int getID() {
		return id;
	}

	/**
	 * Getter for navnet på brugeren
	 * @return Navnet på brugeren
	 */
	public String getName() {
		return name;
	}

}
