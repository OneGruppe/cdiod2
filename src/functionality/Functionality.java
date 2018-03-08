package functionality;

import java.util.concurrent.TimeUnit;

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
			// 3 - Operatørens navn findes i databasen og vises på vægten
				int userInput = w.getInputWithMsg("Indtast operatørnummer");
					w.showLongMsg(d.userInDatabase(userInput).getName());

			// 4 - Operatøren kvitterer for at navnet er korrekt
					TimeUnit.SECONDS.sleep(3);
					w.getInputWithMsg("Indtast 1, for at kvittere.");
					
			// 5 - Vægten beder om, at der indtastes batch nummer (område 1000-9999)

			// 6 - Operatør indtaster batch nummer

			// 7 - Operatøren instrueres om, at vægten skal være ubelastet

			// 8 - Operatøren kvitterer
					TimeUnit.SECONDS.sleep(3);
					w.getInputWithMsg("Indtast 1, for at kvittere.");
					
			// 9 - Vægten tareres

			// 10 - Operatøren instrueres om, at placere tara (tom beholder)  på vægten

			// 11 - Operatøren kvitterer
					TimeUnit.SECONDS.sleep(3);
					w.getInputWithMsg("Indtast 1, for at kvittere.");
					
			// 12 - Tara’s vægt registreres

			// 13 - Vægten tareres

			// 14 - Operatøren instrueres i at placere netto (beholder med produkt)  på vægten 

			// 15 - Operatøren kvitterer
					TimeUnit.SECONDS.sleep(3);
					w.getInputWithMsg("Indtast 1, for at kvittere.");
					
			// 16 - Nettovægt registreres

			// 17 - Vægten tareres

			// 18 - Operatøren instrueres i at fjerne brutto fra vægten

			// 19 - Operatøren kvitterer
					TimeUnit.SECONDS.sleep(3);
					w.getInputWithMsg("Indtast 1, for at kvittere.");
					
			// 20 - Bruttovægt registreres (negativ)

			// 21 - Der udskrives OK eller kasseret på vægten

			// 22 - Operatøren kvitterer

			// 23 - Vægten tareres
			
		} catch (WeightException | InterruptedException e) {
			System.out.println(e);
		}
	}
}
