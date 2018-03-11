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

	private final int WEIGHT_PORT = 8000; 

	public Weight_Translate(String ip) {

		try {
			// create socket connection with ip and port, delivered from Main
			socket = new Socket(ip, WEIGHT_PORT);

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
	 * @param message Den besked der vises på UI.
	 * @throws IOException
	 */
	public void showMsg(String message) throws WeightException {

		try {
			System.out.println("\n*********************************************************");
			System.out.println("Running function showMsg(" + message + ")");

			// write commands to the weight (open telnet)
			write.println("D "+ "\"" + message + "\"");

			System.out.println(message + " successfully displayed");

			System.out.println("Tries to readLine()");
			// read the response of the weight
			System.out.println(read.readLine());

			System.out.println("ReadLine successful");
			System.out.println("---------------------------------------------------------\n");
		} catch (IOException e) {
			System.out.println("\n   !! !! !! !! !! !! !! ERROR !! !! !! !! !! !! !!   \n");
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

		try {
			System.out.println("\n*********************************************************");
			System.out.println("Running function showLongMsg(" + message +")");
			write.println("P111 " + "\"" + message + "\"");
			System.out.println(message + " successfully displayed");
			System.out.println("Tries to readLine()");
			System.out.println(read.readLine());
			System.out.println("ReadLine successful");
			System.out.println("---------------------------------------------------------\n");
		}
		catch (IOException e) {
			System.out.println("\n   !! !! !! !! !! !! !! ERROR !! !! !! !! !! !! !!   \n");
			throw new WeightException("Error showing long message");
		}
	}

	/**
	 * Fjerner beskeden fra display
	 */
	public void removeMsg() throws WeightException {

		try {
			System.out.println("\n*********************************************************");
			System.out.println("Running function removeMsg()");
			// Write commends to the weight (open telnet)
			write.println("DW");
			System.out.println("RemoveMsg successful");

			System.out.println("Tries to readLine()");
			// Read the response from he weight
			System.out.println(read.readLine());
			System.out.println("ReadLine() successful");
			System.out.println("---------------------------------------------------------\n");
		} catch (IOException e) {
			System.out.println("\n   !! !! !! !! !! !! !! ERROR !! !! !! !! !! !! !!   \n");
			throw new WeightException("Error deleting message");
		}
	}

	/**
	 * Skriver en besked til UI, og får en int tilbage fra vægt.
	 */
	public int getInputWithMsg(String message) throws WeightException {

		try {
			System.out.println("\n*********************************************************");
			System.out.println("Running function getInputWithMsg(" + message + ")");
			//Sends message to weight with a given message
			write.println("RM20 8 " + "\"" + message + "\" " + "\" \" " + "\"&3\"");
			System.out.println(message + " successfully displayed");

			System.out.println("Tries to readLine(), reading response from user");
			//Reads the input the user response with
			System.out.println(read.readLine());

			String response = read.readLine();
			System.out.println(response + " successfully read and saved into string response");

			// creates a string that only consists of the numbers in response
			String InputString = response.substring(8, (response.length() - 1));
			System.out.println("Cuts " + response + " into " + InputString);
			System.out.println(InputString);

			if(InputString.equals("")) {
				System.out.println("---------------------------------------------------------\n");
				return 0;
			}

			int resultInt = Integer.parseInt(InputString);
			System.out.println("getInputWithMsg successfully run");
			System.out.println("---------------------------------------------------------\n");
			return resultInt;

		} catch(IOException e) {
			System.out.println("\n   !! !! !! !! !! !! !! ERROR !! !! !! !! !! !! !!   \n");
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
			System.out.println("\n*********************************************************");
			System.out.println("Running function getWeight()");
			write.println("S");
			System.out.println("getWeight ran successfully");

			System.out.println("awaits response");
			String response = read.readLine();
			System.out.println(response + " successfully stored into response string");

			// extracts only the numbers from response to a string
			System.out.println("Cuts the response into useful string");
			String weightString = response.substring(9, (response.length() - 2));
			System.out.println("String successfully cut into: " + weightString);

			// convert from string to double.
			System.out.println("Converts " + weightString + " into double");
			double weight = Double.parseDouble(weightString);
			System.out.println("Convertion successful" + weightString + " is now double " + weight);
			System.out.println("---------------------------------------------------------\n");
			return weight;

		} catch(IOException e) {
			System.out.println("\n   !! !! !! !! !! !! !! ERROR !! !! !! !! !! !! !!   \n");
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
			System.out.println("\n*********************************************************");
			System.out.println("Running function setTaraWeight()");
			// T command retrieves weight
			write.println("T");
			System.out.println("function setTaraWeight ran successfully ");

			System.out.println("Awaits response");
			String response = read.readLine();
			System.out.println("response accepted into string: " + response);

			// extracts only the numbers from response to a string
			String weightString = response.substring(9, (response.length() - 2));
			System.out.println("cuts " + response + " into string " + weightString);

			// convert from string to double.
			double weight = Double.parseDouble(weightString);
			System.out.println("Converts " + weight + " into double " + weight);
			System.out.println("---------------------------------------------------------\n");
			return weight;

		} catch (IOException e) {
			System.out.println("\n   !! !! !! !! !! !! !! ERROR !! !! !! !! !! !! !!   \n");
			throw new WeightException("Error showing Tara weight");
		}
	}

	public String waitForMessage() throws WeightException {

		try {
			System.out.println("\n*********************************************************");
			System.out.println("Running function waitForMessage()");
			System.out.println("Reading line");
			String msgread = read.readLine();
			System.out.println("' " + msgread + " ' was read from the weight");
			System.out.println("---------------------------------------------------------\n");
			return msgread;
		} catch (IOException e) {
			throw new WeightException("Error trying to get message");
		}
	}

	public void shutdownWeight(int i) throws WeightException, IOException{
		System.out.println("\n*********************************************************");
		if(i == 1) { // Virtual Shutdown
			System.out.println("Running function shutdownWeight()");
			write.println("Q ");
			System.out.println(read.readLine());
			System.out.println("shutdown ran successfully");
		}
		else if(i == 2) {
			System.out.println("Running function shutdownWeight()");
			write.println("PWR 0");
			System.out.println(read.readLine());
			System.out.println("shutdown ran successfully");
		}
		System.out.println("** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** \n");
	}

	public void setVirtualWeight(double wantedWeight) throws WeightException{
		System.out.println("\n*********************************************************");
		System.out.println("Running function setVirtualWeight(" + wantedWeight +")");
		write.println("B " + wantedWeight);
		System.out.println("---------------------------------------------------------\n");
	}

	public void closeAllLeaks() throws WeightException {

		try {
			System.out.println("\n*********************************************************");
			System.out.println("closes all leaks");
			socket.close();
			write.close();
			read.close();
			System.out.println("All leaks successfully closed");
			System.out.println("---------------------------------------------------------\n");
			
		} catch (IOException e) {
			System.out.println("\n   !! !! !! !! !! !! !! ERROR !! !! !! !! !! !! !!   \n");
			throw new WeightException("Could not close connection");
		}
	}

}
