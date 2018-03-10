package data;

public class Batch {

	private int id;
	private String desc;
	private double bruttoWeight;
	
	public Batch(int id, String desc, double bruttoWeight) {
		this.id = id;
		this.desc = desc;
		this.bruttoWeight = bruttoWeight;
	}

	public int getID() {
		return id;
	}

	public String getDesc() {
		return desc;
	}

	public double getBruttoWeight () {
		return bruttoWeight;
	}

	public void addBruttoWeight (double addWeight) {
		bruttoWeight += addWeight;
	}

	public void resetBruttoWeight () {
		bruttoWeight = 0;
	}

}
