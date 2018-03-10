package main;

import functionality.*;

public class Main {

	public static void main(String[] args){

			// Fysisk vægt (2)
		//IFunctionality f = new Functionality_Psysical();
			// Virtuel vægt
		IFunctionality f = new Functionality_Virtual();
		f.weightFlow();
	}

}
