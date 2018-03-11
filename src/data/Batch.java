package data;

/**
 * Batch class last edited 11.03.2018 - 03:28
 * @author Group 12
 *
 */

public class Batch {

	private int id;
	private String desc;
	private double bruttoWeight;
	
	/**
	 * Konstruktør til batch der indeholder
	 * @param id ID af batch
	 * @param desc Beskrivelse af batch
	 * @param bruttoWeight Brutto vægten af batch
	 */
	public Batch(int id, String desc, double bruttoWeight) {
		this.id = id;
		this.desc = desc;
		this.bruttoWeight = bruttoWeight;
	}

	/**
	 * Getter til batch ID
	 * @return ID af batch
	 */
	public int getID() {
		return id;
	}

	/**
	 * Getter til batch description
	 * @return Description af batch
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * Getter til vægten af batch
	 * @return brutto vægten af batchen
	 */
	public double getBruttoWeight () {
		return bruttoWeight;
	}

	/**
	 * Tilføjer vægt til brutto vægten
	 * @param addWeight Tilføjer den mængde der indtastes til brutto vægten.
	 */
	public void addBruttoWeight (double addWeight) {
		bruttoWeight += addWeight;
	}

	/**
	 * Resetter brutto vægten tilbage til 0
	 */
	public void resetBruttoWeight () {
		bruttoWeight = 0;
	}

}
