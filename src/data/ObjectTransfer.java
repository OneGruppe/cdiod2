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
		Batch batch1 = new Batch(d.getBatchid(), d.getBatchdesc());
		batchlist.add(batch1);
	}

	protected ArrayList<User> getUserlist() {
		return userlist;
	}

	protected ArrayList<Batch> getBatchlist() {
		return batchlist;
	}
	
}
