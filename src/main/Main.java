package main;

import functionality.*;

/**
 * Main method for the whole program last edited 11.03.2018 - 03.58
 * @author Group 12
 *
 */

public class Main {

	/**
	 * Main metode som forbinder til enten simulatoren eller til den fysiske maskine
	 * @param args
	 */
	public static void main(String[] args){

		// Actual weight (2)
		// IFunctionality f = new Functionality_Psysical("169.254.2.3");
		
		// Virtual weight
		IFunctionality f = new Functionality_Virtual("127.0.0.1");
		f.weightFlow();
	}

}
