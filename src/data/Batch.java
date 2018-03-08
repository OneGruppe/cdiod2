package data;

public class Batch {

	private int id;
	private String desc;
	private double bruttoWeight;
	private double nettoWeight;
	private double taraWeight;
	
	public Batch(int id, String desc, double bruttoWeight, double nettoWeight, double taraWeight) {
		this.taraWeight = taraWeight;
		this.id = id;
		this.desc = desc;
		this.bruttoWeight = bruttoWeight;
		this.nettoWeight = nettoWeight;
	}

	public double getTaraWeight () {
		return taraWeight;
	}

	public void addTaraWeight (double addedWeight) {
		taraWeight += addedWeight;
	}

	public void resetTaraWeught () {
		taraWeight = 0;
	}

	public double getNettoWeight () {
		return nettoWeight;
	}

	public void addNettoWeight (double addedWeight) {
		nettoWeight += addedWeight;
	}

	public void resetNettoWeight () {
		nettoWeight = 0;
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
