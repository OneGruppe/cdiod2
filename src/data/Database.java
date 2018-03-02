package data;

public class Database {
	
	// User - standardData
	private int userid = 1;
	private String userName = "Anders And";
	// Batch - standardData
	private int batchid = 1234;
	private String batchdesc = "Salt";
	
	protected int getUserid() {
		return userid;
	}
	protected String getUserName() {
		return userName;
	}
	protected int getBatchid() {
		return batchid;
	}
	protected String getBatchdesc() {
		return batchdesc;
	}
	
}
