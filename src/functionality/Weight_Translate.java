package functionality;

import java.net.Socket;

public class Weight_Translate {
	private Socket sock;
	// ******************************************
	// Denne klasse har direkte adgang til vægten
	// ******************************************
	public Weight_Translate(){
		try {
			sock = new Socket ("127.0.0.1", 8000);
		}
		catch(Exception e) {

		}
	}
	
	/**
	 * Viser en besked på display
	 * @param message Den besked der vises på UI.
	 */
	public void showMsg(String message) throws WeightException{	
		
	}

	/**
	 * Viser en lang besked på display
	 * @param message Den besked der vises på UI.
	 */
	public void showLongMsg(String message) throws WeightException{	

	}

	/**
	 * Fjerner beskeden fra display
	 */
	public void removeMsg() throws WeightException{

	}

	/**
	 * Skriver en besked til UI, og får en besked tilbage fra vægt.
	 */
	public String getInputWithMsg(String message) throws WeightException{

		return null;
	}

	/**
	 * Trækker information om nuværende vægt-info
	 * @return vægt i double
	 */
	public double getWeight() throws WeightException{

		return 0;
	}

	/**
	 * Trækker information om nuværende Tara-vægt
	 * @return Tara vægt i double
	 */
	public double getTaraWeight() throws WeightException{

		return 0;
	}
}
