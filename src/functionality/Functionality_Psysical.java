package functionality;
import java.io.IOException;
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
		int userInput, batchInput;
		double taraWeight, nettoWeight, bruttoWeight;
		try {		
			while(true) {

				// 1 - Vægten beder om, at der indtastes operatørnummer
				// 2 - Operatøren indtaster sit brugernummer (område 11-99)
				while (true) {
					w.removeMsg();
					userInput = w.getInputWithMsg("Indtast operatørnummer");
					System.out.println(userInput);
					w.removeMsg();
					// 3 - Operatørens navn findes i databasen og vises på vægten
					w.showLongMsg("Valgt bruger: " + d.userInDatabase(userInput).getName());

					// 4 - Operatøren kvitterer for at navnet er korrekt
					TimeUnit.SECONDS.sleep(2);
					w.removeMsg();
					int ok = w.getInputWithMsg("Tast 1, hvis korrekt");
					w.removeMsg();
					if (ok == 1) {
						break;
					}
				}

				// 5 - Vægten beder om, at der indtastes batch nummer (område 1000-9999)
				// 6 - Operatør indtaster batch nummer
				while(true) {
					batchInput = w.getInputWithMsg("Indtast batch nummer");
					d.batchInDatabase(batchInput);
					w.removeMsg();

					w.showLongMsg("Valgt batch: " + d.batchInDatabase(batchInput).getDesc());

					// 8 - Operatøren kvitterer
					TimeUnit.SECONDS.sleep(2);
					w.removeMsg();
					int ok = w.getInputWithMsg("Tast 1, hvis korrekt");
					w.removeMsg();
					if (ok == 1) {
						break;
					}
				}
				while(true) {
					// 7 - Operatøren instrueres om, at vægten skal være ubelastet
					w.showLongMsg("Fjern alt last fra vægten");
					TimeUnit.SECONDS.sleep(2);
					w.removeMsg();
					int ok = w.getInputWithMsg("Tast 1, hvis fjernet");
					w.removeMsg();
					if (ok == 1) {
						break;
					}
				}
				// 9 - Vægten tareres
				w.setTaraWeight();

				// 10 - Operatøren instrueres om, at placere tara (tom beholder)  på vægten
				while (true) {

					w.showLongMsg("Placer en tom beholder på vægten");

					// 11 - Operatøren kvitterer
					TimeUnit.SECONDS.sleep(2);
					w.removeMsg();
					int ok = w.getInputWithMsg("Tast 1, når placeret");
					w.removeMsg();

					if (ok == 1) {
						break;
					}
				}

				while(true) {

					// 12 - Tara’s vægt registreres
					taraWeight = w.getWeight();
					w.showLongMsg("Tara-vægt: " + taraWeight + "kg, registreret"); 
					TimeUnit.SECONDS.sleep(2);
					w.removeMsg();

					// 13 - Vægten tareres
					w.setTaraWeight();

					int ok = w.getInputWithMsg("Tast 1, hvis korrekt");
					w.removeMsg();

					if (ok == 1) {
						break;
					}
				}

				while(true) {
					// 14 - Operatøren instrueres i at placere netto (beholder med produkt)  på vægten
					w.showLongMsg("Placer beholder med produkt på vægten"); 

					// 15 - Operatøren kvitterer
					TimeUnit.SECONDS.sleep(3);
					w.removeMsg();
					int ok = w.getInputWithMsg("Tast 1, når placeret");
					w.removeMsg();
					if (ok == 1) {
						break;
					}
				}

				while(true) {

					// 16 - Nettovægt registreres
					// 17 - Vægten tareres
					nettoWeight = w.getWeight();
					w.showLongMsg("Netto-vægt: " + nettoWeight + "kg, registreret"); 
					TimeUnit.SECONDS.sleep(4);
					w.removeMsg();

					// 18 - Operatøren instrueres i at fjerne brutto fra vægten
					w.showLongMsg("Fjern produkt fra vægt");

					// 19 - Operatøren kvitterer
					TimeUnit.SECONDS.sleep(2);
					w.removeMsg();
					int ok = w.getInputWithMsg("Tast 1, hvis fjernet");
					w.removeMsg();
					if (ok == 1) {
						break;
					}
				}

				while(true) {

					// 20 - Bruttovægt registreres (negativ)
					bruttoWeight = nettoWeight + taraWeight;

					// 21 - Der udskrives OK eller kasseret på vægten
					w.showLongMsg("Brutto: " + bruttoWeight + " kg, tast '1' = tilføj til batch, '2' = smides ud");

					// 22 - Operatøren kvitterer
					TimeUnit.SECONDS.sleep(4);
					w.removeMsg();
					int ok = w.getInputWithMsg("'1'=gem,'2'=ud");

					w.removeMsg();
					if (ok == 1) {
						w.showLongMsg("Bruttovægten er gemt i batch");
						d.batchInDatabase(batchInput).addBruttoWeight(bruttoWeight);
						TimeUnit.SECONDS.sleep(2);
						w.removeMsg();
						break;
					}
					if (ok == 2) {
						w.showLongMsg("Bruttovægten er fjernet fra batch");
						d.batchInDatabase(batchInput).addBruttoWeight(bruttoWeight * (-1));
						TimeUnit.SECONDS.sleep(2);
						w.removeMsg();
						break;
					}
				}

				// 23 - Vægten tareres
				w.setVirtualWeight(0);
				w.setTaraWeight();

				w.showLongMsg("Process fuldført tast '1' + ok for at lukke program, '2' for at starte forfra");
				TimeUnit.SECONDS.sleep(4);
				int ok = w.getInputWithMsg("'1'=sluk,'2'=forfra");
				if (ok == 1) {
					w.shutdownWeight(2);
					w.closeAllLeaks();
					System.exit(0);
				}
				w.removeMsg();
			}

		} catch (WeightException | InterruptedException | IOException e) {

			System.out.println(e);
		}
	}
}
