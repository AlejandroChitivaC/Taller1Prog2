package co.edu.unbosque.controller;

import co.edu.unbosque.model.CSV;

public class Controller {

    private final CSV csv;

    public Controller() {
        csv = new CSV("csv/data.csv");

        for (var i : csv.getCsvList()) {
            System.out.println(i.toString());
        }
    }
}
