package data;

import java.util.ArrayList;

public class ObjectTransfer {
	private Database d;
	private ArrayList<User> userlist;
	private ArrayList<Batch> batchlist;

	public ObjectTransfer(){
		// Opret ny instans a datalag (i stedet for database)
		d = new Database();

		//Users
		userlist = new ArrayList<User>();
		User user12 = new User(d.getUserid(), d.getUserName());
		userlist.add(user12);

		//Batch
		batchlist = new ArrayList<Batch>();
		Batch batch1 = new Batch(d.getBatchid(), d.getBatchdesc(), 0.0, 0.0, 0.0);
		batchlist.add(batch1);
	}

	public User userInDatabase(int userID) {
		for(User u: userlist) {
			if(userID == u.getId()) {
				return u;
			}
		}
		return null;
	}

	public Batch batchInDatabase(int batchID) {
		for(Batch b: batchlist) {
			if(batchID == b.getID()) {
				return b;
			}
		}
		return null;
	}

}
