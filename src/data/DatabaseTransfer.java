package data;

import java.util.ArrayList;

/**
 * DatebaseTransfer class last edited 11.03.2018 - 03.33
 * @author Group 12
 *  
 */

public class DatabaseTransfer {
	
	private Database d;
	private ArrayList<User> userlist;
	private ArrayList<Batch> batchlist;

	public DatabaseTransfer(){
	
		// Laver en ny instans af datalag istedet for database
		d = new Database();

		//Users
		userlist = new ArrayList<User>();
		User user12 = new User(d.getUserID(), d.getUsername());
		userlist.add(user12);

		//Batch
		batchlist = new ArrayList<Batch>();
		Batch batch1 = new Batch(d.getBatchID(), d.getBatchDesc(), 0.0);
		batchlist.add(batch1);
	
	}

	/**
	 * Finder den bruer med det indtastede ID og returnerer objektet af den bruger
	 * @param userID ID på den bruger der ønskes at få
	 * @return Objekt af brugeren, hvis der er et match, hvis ikke så returneres null
	 */
	public User userInDatabase(int userID) {
		for(User u: userlist) {
			if(userID == u.getID()) {
				return u;
			}
		}
		
		return null;
	}

	/**
	 * Finder det batch for det indtastede ID og så returnerer objektet for det batch
	 * @param batchID ID af det ønskede batch
	 * @return Objektet af det batch der indtastes, hvis intet match returneres null
	 */
	public Batch batchInDatabase(int batchID) {	
		for(Batch b: batchlist) {
			if(batchID == b.getID()) {
				return b;
			}
		}
		
		return null;
	}

}
