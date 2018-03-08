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
			// Virtuel vægt
			socket = new Socket("127.0.0.1", 8000);
			
			// Den fysiske vægt(2)
			// socket = new Socket("169.254.2.3", 8000);

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
	 * 
	 * @param message
	 *            Den besked der vises på UI.
	 * @throws IOException
	 */
	public void showMsg(String message) throws WeightException {
		try {
			// write commands to the weight (open telnet)
			write.println("D "+ "\"" + message + "\"");

			// read the response of the weight
			System.out.println(read.readLine());
			
		} catch (IOException e) {
			
			throw new WeightException("Error showing message");
		}
	}

	/**
	 * Viser en lang besked på display
	 * 
	 * @param message
	 *            Den besked der vises på UI.
	 */
	public void showLongMsg(String message) throws WeightException {
		
		write.println("P111 " + "\"" + message + "\"");
		
		try {
			System.out.println(read.readLine());
		} 
		catch (IOException e) {
			throw new WeightException("Error showing long message");
		}

	}

	/**
	 * Fjerner beskeden fra display
	 */
	public void removeMsg() throws WeightException {
		
		try {
			// Write commends to the weight (open telnet)
			write.println("DW");

			// Read the response from he weight
			System.out.println(read.readLine());
			
		} catch (IOException e) {
			
			throw new WeightException("Error deleting message");
		}
	}

	/**
	 * Skriver en besked til UI, og får en int tilbage fra vægt.
	 */
	public int getInputWithMsg(String message) throws WeightException {
		try {
			//Sends message to weight with a given message
			write.println("RM20 8 " + "\"" + message + "\" " + "\" \" " + "\"&3\"");
			
			//Reads the input the user respons with
			System.out.println(read.readLine());

			String response = read.readLine();

			// creates a string that only consists of the numbers in response
			String InputString = response.substring(8, (response.length() - 1));
			System.out.println(InputString);

			int resultInt = Integer.parseInt(InputString);
			
			return resultInt;
			
		} catch(IOException e) {
			
			throw new WeightException("Error getting the input");
		}
	}

	/**
	 * Trækker information om nuværende vægt-info
	 * 
	 * @return vægt i double
	 * @throws IOException
	 */
	public double getWeight() throws WeightException {
		try {
			// S command retrieves weight
			write.println("S");

			String response = read.readLine();

			// extracts only the numbers from response to a string
			String weightString = response.substring(9, (response.length() - 2));

			// convert from string to double.
			double weight = Double.parseDouble(weightString);

			return weight;
			
		} catch(IOException e) {
			
			throw new WeightException("Error showing weight");
		}
	}

	/**
	 * Trækker information om nuværende Tara-vægt
	 * 
	 * @return Tara vægt i double
	 * @throws IOException 
	 */
	public double setTaraWeight() throws WeightException {
		
		try {
			// T command retrieves weight
			write.println("T");

			String response = read.readLine();

			// extracts only the numbers from response to a string
			String weightString = response.substring(9, (response.length() - 2));

			// convert from string to double.
			double weight = Double.parseDouble(weightString);

			return weight;
			
		} catch (IOException e) {
			
			throw new WeightException("Error showing Tara weight");
		}
	}
	
	public void closeAllLeaks() throws WeightException {
		
		try {
			socket.close();
			write.close();
			read.close();
		} catch (IOException e) {
			
			throw new WeightException("Could not close connection");
		}
	}
}
