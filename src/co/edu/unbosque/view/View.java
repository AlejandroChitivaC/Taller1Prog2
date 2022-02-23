package co.edu.unbosque.view;

import java.util.Scanner;

/**
 * The type View.
 */
public class View {
	private Scanner scan;

	/**
	 * Instantiates a new View.
	 */
	public View() {

			scan = new Scanner(System.in);
	}

	/**
	 * Pedir dato string.
	 *
	 * @param mensaje the mensaje
	 * @return the string
	 */
	public String pedirDato(String mensaje) {
		System.out.println(mensaje);
		return scan.nextLine();
	}


}


