package main;

import functionality.*;

public class Main {

	public static void main(String[] args){

			// Fysisk vægt (2)
		//IFunctionality f = new Functionality_Psysical("169.254.2.3", 8000);
			// Virtuel vægt
		IFunctionality f = new Functionality_Virtual("127.0.0.1", 8000);
		f.weightFlow();
	}

}
