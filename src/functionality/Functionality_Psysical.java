package functionality;
import java.util.concurrent.TimeUnit;

import data.*;

public class Functionality_Psysical implements IFunctionality {
	
	private DatabaseTransfer d;
	private Weight_Translate w;

	public Functionality_Psysical(String ip) {
		
		d = new DatabaseTransfer();
		w = new Weight_Translate(ip);
	}

	/**
	 * Kører flow for vægten.
	 */
	public void weightFlow(){
		
		int userInput;
		int batchInput;
		
		try {		
		
			while(true) {
				
				// 1 - Vægten beder om, at der indtastes operatørnummer
				// 2 - Operatøren indtaster sit brugernummer (område 11-99)
				while (true) {
					
					userInput = w.getInputWithMsg("Indtast operatørnummer");
					System.out.println(userInput);
					
					// 3 - Operatørens navn findes i databasen og vises på vægten
					w.showLongMsg("Navn: " + d.userInDatabase(userInput).getName());

					// 4 - Operatøren kvitterer for at navnet er korrekt
					TimeUnit.SECONDS.sleep(2);
					int ok = w.getInputWithMsg("Tryk ok, for at bekræfte.");
					
					if (ok == 0) {
						break;
					}
				}

				// 5 - Vægten beder om, at der indtastes batch nummer (område 1000-9999)
				// 6 - Operatør indtaster batch nummer
				while(true) {
					
					batchInput = w.getInputWithMsg("Indtast batch nummer.");
					d.batchInDatabase(batchInput);

					// 7 - Operatøren instrueres om, at vægten skal være ubelastet
					w.showLongMsg("Batch :" + d.batchInDatabase(batchInput).getDesc());
					TimeUnit.SECONDS.sleep(2);
					w.showLongMsg("Fjern alt last fra vægten.");

					// 8 - Operatøren kvitterer
					TimeUnit.SECONDS.sleep(2);
					int ok = w.getInputWithMsg("Tryk ok, for at bekræfte.");
					
					if (ok == 0) {
						break;
					}
				}

				// 9 - Vægten tareres
				// 10 - Operatøren instrueres om, at placere tara (tom beholder)  på vægten
				while (true) {
					
					w.showLongMsg("Placer en tom beholder på vægten");
					w.setTaraWeight();

					// 11 - Operatøren kvitterer
					TimeUnit.SECONDS.sleep(2);
					int ok = w.getInputWithMsg("Tryk ok, for at bekræfte.");
					
					if (ok == 0) {
						break;
					}
				}

				while(true) {
					
					// 12 - Tara’s vægt registreres
					d.batchInDatabase(batchInput).addTaraWeight(w.getWeight());

					// 13 - Vægten tareres
					w.setTaraWeight();

					// 14 - Operatøren instrueres i at placere netto (beholder med produkt)  på vægten
					w.showLongMsg("Placer beholder med produkt på vægten (5 sek.)"); 

					// 15 - Operatøren kvitterer
					TimeUnit.SECONDS.sleep(5);
					int ok = w.getInputWithMsg("Tryk ok, for at bekræfte.");
					
					if (ok == 0) {
						break;
					}
				}

				while(true) {
					
					// 16 - Nettovægt registreres
					d.batchInDatabase(batchInput).addNettoWeight(2); //Den givne kg på vægten?

					// 17 - Vægten tareres
					w.setTaraWeight();

					// 18 - Operatøren instrueres i at fjerne brutto fra vægten
					w.showLongMsg("Fjern produkt fra vægt");

					// 19 - Operatøren kvitterer
					TimeUnit.SECONDS.sleep(2);
					int ok = w.getInputWithMsg("Tryk ok, for at bekræfte.");
					
					if (ok == 0) {
						break;
					}
				}

				while(true) {
					
					// 20 - Bruttovægt registreres (negativ)
					d.batchInDatabase(batchInput).addNettoWeight(d.batchInDatabase(2).getBruttoWeight()*-1);

					// 21 - Der udskrives OK eller kasseret på vægten
					w.showMsg("ok!");

					// 22 - Operatøren kvitterer
					TimeUnit.SECONDS.sleep(2);
					int ok = w.getInputWithMsg("Tryk ok, for at bekræfte.");
					
					if (ok == 0) {
						break;
					}
				}

				// 23 - Vægten tareres
				w.setTaraWeight();

				w.showLongMsg("This batch-process is done. \n Press '1' to close program, anything else to start over.");
			}

		} catch (WeightException | InterruptedException e) {
			
			System.out.println(e);
		}
	}
}
