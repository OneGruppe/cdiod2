package data;

/**
 * Database class last edited 11.03.2018 - 03.30
 * @author Group 12
 *
 */

public class Database {
	
	// User - standardData
	private int userID = 12; // Test ID
	private String username = "Anders And"; //Test user
	
	// Batch - standardData
	private int batchID = 1234; //Test batch
	private String batchDesc = "Salt"; //Test description for batch
	
	/**
	 * Getter til UserID
	 * @return UserID
	 */
	protected int getUserID() {
		return userID;
	}
	
	/**
	 * Getter til username
	 * @return Username
	 */
	protected String getUsername() {
		return username;
	}
	
	/**
	 * Getter til batch ID
	 * @return Batch ID
	 */
	protected int getBatchID() {
		return batchID;
	}
	
	/**
	 * Getter til batch description
	 * @return Batch description
	 */
	protected String getBatchDesc() {
		return batchDesc;
	}
	
}
