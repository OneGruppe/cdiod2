package main;

import functionality.*;

public class Main {

	public static void main(String[] args){

		// Actual weight (2)
		//IFunctionality f = new Functionality_Psysical("169.254.2.3", 8000);
		
		// Virtual weight
		IFunctionality f = new Functionality_Virtual("127.0.0.1");
		f.weightFlow();
	}

}
