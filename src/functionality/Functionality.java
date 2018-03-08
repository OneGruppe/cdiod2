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
			int userInput = w.getInputWithMsg("Indtast operatørnummer");
			// 3 - Operatørens navn findes i databasen og vises på vægten
			w.showLongMsg(d.userInDatabase(userInput).getName());

			// 4 - Operatøren kvitterer for at navnet er korrekt
			TimeUnit.SECONDS.sleep(3);
			w.getInputWithMsg("Indtast 1, for at kvittere.");

			// 5 - Vægten beder om, at der indtastes batch nummer (område 1000-9999)
			// 6 - Operatør indtaster batch nummer
			int batchID = w.getInputWithMsg("Indtast batch nummer.");
			d.batchInDatabase(batchID);

			// 7 - Operatøren instrueres om, at vægten skal være ubelastet
			w.showLongMsg("Fjern alt last fra vægten.");

			// 8 - Operatøren kvitterer
			TimeUnit.SECONDS.sleep(3);
			w.getInputWithMsg("Indtast 1, for at kvittere.");

			// 9 - Vægten tareres
			// 10 - Operatøren instrueres om, at placere tara (tom beholder)  på vægten
			w.showLongMsg("Placer en tom beholder på vægten");
			w.setTaraWeight();

			// 11 - Operatøren kvitterer
			TimeUnit.SECONDS.sleep(3);
			w.getInputWithMsg("Indtast 1, for at kvittere.");

			// 12 - Tara’s vægt registreres
			d.batchInDatabase(batchID).addTaraWeight(w.getWeight());

			// 13 - Vægten tareres
			w.setTaraWeight();

			// 14 - Operatøren instrueres i at placere netto (beholder med produkt)  på vægten
			w.showLongMsg("Placer beholder med produkt på vægten"); 

			// 15 - Operatøren kvitterer
			TimeUnit.SECONDS.sleep(3);
			w.getInputWithMsg("Indtast 1, for at kvittere.");

			// 16 - Nettovægt registreres
			d.batchInDatabase(batchID).addNettoWeight(2); //Den givne kg på vægten?

			// 17 - Vægten tareres
			w.setTaraWeight();

			// 18 - Operatøren instrueres i at fjerne brutto fra vægten
			w.showLongMsg("Fjern produkt fra vægt");

			// 19 - Operatøren kvitterer
			TimeUnit.SECONDS.sleep	(3);
			w.getInputWithMsg("Indtast 1, for at kvittere.");

			// 20 - Bruttovægt registreres (negativ)
			d.batchInDatabase(batchID).addNettoWeight(d.batchInDatabase(2).getBruttoWeight()*-1);

			// 21 - Der udskrives OK eller kasseret på vægten
			w.showMsg("ok!");

			// 22 - Operatøren kvitterer
			TimeUnit.SECONDS.sleep(3);
			w.getInputWithMsg("Indtast 1, for at kvittere.");

			// 23 - Vægten tareres
			w.setTaraWeight();


		} catch (WeightException | InterruptedException e) {
			System.out.println(e);
		}
	}
}
