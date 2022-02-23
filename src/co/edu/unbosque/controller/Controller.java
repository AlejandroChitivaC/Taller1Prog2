package co.edu.unbosque.controller;

import co.edu.unbosque.model.CSV;
import co.edu.unbosque.view.View;

/**
 * The type Controller.
 */
public class Controller {

	private final CSV csv;
	private final View view;


	/**
	 * Instantiates a new Controller.
	 */
	public Controller() {
		csv = new CSV("csv/data.csv");
		view = new View();
		for (var i : csv.getCsvList()) {
			System.out.println(i.toString());

		}
		System.out.println(csv.Summary());
		System.out.println(csv.getCsvList().get(0).getQuantity());

		String busqueda = view.pedirDato("Ingrese el InvoiceNo que desea buscar");
		System.out.println(csv.findByInvoiceNo(busqueda));

	}
}
