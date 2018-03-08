package functionality;

import data.*;

public class Functionality {
	private ObjectTransfer d;
	private Weight_Translate w;
	
	public Functionality(){
		d = new ObjectTransfer();
		w = new Weight_Translate();
	}
	
	/**
	 * Kører flow for vægten.
	 */
	public void weightFlow(){

		try {		

			// 1 - Vægten beder om, at der indtastes operatørnummer
			// 2 - Operatøren indtaster sit brugernummer (område 11-99)
				int userInput = w.getInputWithMsg("Indtast operatørnummer");
					w.showLongMsg(d.isUserInDatabase(userInput));

			// 3 - Operatørens navn findes i databasen og vises på vægten

			// 4 - Operatøren kvitterer for at navnet er korrekt

			// 5 - Vægten beder om, at der indtastes batch nummer (område 1000-9999)

			// 6 - Operatør indtaster batch nummer

			// 7 - Operatøren instrueres om, at vægten skal være ubelastet

			// 8 - Operatøren kvitterer

			// 9 - Vægten tareres

			// 10 - Operatøren instrueres om, at placere tara (tom beholder)  på vægten

			// 11 - Operatøren kvitterer

			// 12 - Tara’s vægt registreres

			// 13 - Vægten tareres

			// 14 - Operatøren instrueres i at placere netto (beholder med produkt)  på vægten 

			// 15 - Operatøren kvitterer

			// 16 - Nettovægt registreres

			// 17 - Vægten tareres

			// 18 - Operatøren instrueres i at fjerne brutto fra vægten

			// 19 - Operatøren kvitterer

			// 20 - Bruttovægt registreres (negativ)

			// 21 - Der udskrives OK eller kasseret på vægten

			// 22 - Operatøren kvitterer

			// 23 - Vægten tareres

			
		} catch (WeightException e) {
			System.out.println(e);
		}
	}
}
