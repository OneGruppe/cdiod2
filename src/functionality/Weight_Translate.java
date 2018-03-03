package functionality;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Weight_Translate {

	// declare socket to open connection to TCP/Telnet
	// declare Writer and reader for I/O
	private Socket socket;
	private PrintWriter write;
	private BufferedReader read;

	// ******************************************
	// Denne klasse har direkte adgang til vægten
	// ******************************************

	public Weight_Translate() {

		try {
			// initialize the socket with the local IP-addr and right port
			socket = new Socket("127.0.0.1", 8000);

			// initialize the writer and the reader with the socket output and input stream
			write = new PrintWriter(socket.getOutputStream(), true);
			read = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// catch of exceptions
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

	}

	/**
	 * Viser en besked på display
	 * @param message Den besked der vises på UI.
	 * @throws IOException 
	 */
	public void showMsg(String message) throws WeightException, IOException {
		// write commands to the weight (open telnet)
		write.println("D "+ message);

		// read the response of the weight
		System.out.println(read.readLine());

		// insure leak and close everything
		/*write.close();
		read.close();
		socket.close();*/
	}

	/**
	 * Viser en lang besked på display
	 * @param message Den besked der vises på UI.
	 */
	public void showLongMsg(String message) throws WeightException {
		
	}

	/**
	 * Fjerner beskeden fra display
	 */
	public void removeMsg() throws WeightException, IOException {
		//Write commends to the weight (open telnet)
		write.println("DW");
		
		//Read the response from he weight
		System.out.println(read.readLine());
		
		//Closes reader, writer and socket objects
		/*write.close();
		read.close();
		socket.close();*/
	}

	/**
	 * Skriver en besked til UI, og får en besked tilbage fra vægt.
	 */
	public String getInputWithMsg(String message) throws WeightException, IOException {
		//Sends message to weight with a given message
		write.println("RM20 8 "+ message +" \"\"  \"&3\"");
		
		//Reads the input the user respons with
		System.out.println(read.readLine());
		
		String response = read.readLine();
		
		//creates a string that only consists of the numbers in response
		String resultString = response.substring(8, (response.length()-1));
		System.out.println(resultString);
	
		return resultString;
	}

	/**
	 * Trækker information om nuværende vægt-info
	 * @return vægt i double
	 * @throws IOException 
	 */
	public double getWeight() throws WeightException, IOException {
		//S command retrieves weight
		write.println("S");
		
		String response = read.readLine();
		
		//extracts only the numbers from response to a string
		String weightString = response.substring(9, (response.length()-2));
		
		//convert from string to double.
		double weight = Double.parseDouble(weightString);
		
		return weight;
	}

	/**
	 * Trækker information om nuværende Tara-vægt
	 * @return Tara vægt i double
	 */
	public double getTaraWeight() throws WeightException {
		return 0;
	}
}
