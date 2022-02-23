package co.edu.unbosque.controller;

import co.edu.unbosque.model.CSV;

/**
 * The type Controller.
 */
public class Controller {

	private final CSV csv;


	/**
	 * Instantiates a new Controller.
	 */
	public Controller() {
		csv = new CSV("csv/data.csv");
		for (var i : csv.getCsvList()) {
			System.out.println(i.toString());

		}
		System.out.println(csv.Summary());
		System.out.println(csv.getCsvList().get(0).getQuantity());
	}
}
