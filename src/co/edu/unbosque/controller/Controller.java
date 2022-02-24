package co.edu.unbosque.controller;

import co.edu.unbosque.model.CSV;
import co.edu.unbosque.model.Venta;
import co.edu.unbosque.view.View;

import java.util.ArrayList;
import java.util.List;

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

		List<Venta> encontrados;
		do {
			String busqueda = view.pedirDato("Ingrese el InvoiceNo que desea buscar");
			encontrados = csv.findByInvoiceNo(busqueda);
		} while(encontrados.size() == 0);
		System.out.println(encontrados);
// STOCKCODE
		String stockCodes;
		do {
			String stockCode = view.pedirDato("Ingrese el StockCode que desea buscar");
			stockCodes=csv.countByStockCode(stockCode);
		}while (stockCodes.length()==0);
		System.out.println("La cantidad es: "+stockCodes);
		System.out.println(csv.avgMonthlysales());
	}
}
