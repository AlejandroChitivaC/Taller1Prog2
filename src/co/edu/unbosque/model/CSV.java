package co.edu.unbosque.model;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSV {
    private List<Venta> csvList;

    public CSV(String localpath) {
        csvList = new ArrayList<>();
        readFromPath(localpath);
    }

    public void readFromPath(String localpath) {
        System.out.println("Reading a CSV using OpenCSV library");
        try {
            CSVReader reader = new CSVReader(new FileReader(localpath));
            String[] linea;
            reader.readNext();
            do {
                linea = reader.readNext();
                try {
                    String invoiceNo = linea[0];
                    String stockCode = linea[1];
                    String description = linea[2];
                    String quantity = linea[3];
                    String invoiceDate = linea[4];
                    String unitPrice = linea[5];
                    String customerId = linea[6];
                    String country = linea[7];
                    Venta venta = new Venta(invoiceNo, stockCode, description, quantity, invoiceDate, unitPrice, customerId, country);
                    csvList.add(venta);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } while ((linea != null));
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Venta> getCsvList() {
        return csvList;
    }

    public void setCsvList(List<Venta> csvList) {
        this.csvList = csvList;
    }
}
