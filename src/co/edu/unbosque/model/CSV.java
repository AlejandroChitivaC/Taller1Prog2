package co.edu.unbosque.model;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.text.ParseException;
import java.util.*;

/**
 * The type Csv.
 */
public class CSV {
    private static final Object CORREC_DATE_FORMAT = "dd/MM/yyyy";
    private List<Venta> csvList;


    /**
     * Instantiates a new Csv.
     *
     * @param localpath the localpath
     */
    public CSV(String localpath) {
        csvList = new ArrayList<>();
        readFromPath(localpath);
    }

    /**
     * Read from path.
     *
     * @param localpath the localpath
     */
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

    /**
     * Summary float.
     *
     * @return the float
     */
    public float Summary() {
        float total = 0;
        for (int i = 0; i < csvList.size(); i++) {
            Venta aux = csvList.get(i);
            float quantity = Float.parseFloat(aux.getQuantity());
            float unitPrice = Float.parseFloat(aux.getUnitPrice());
            total = total + (quantity * unitPrice);
        }
        return total;
    }

    /**
     * Find by invoice no list.
     *
     * @param search the search
     * @return the list
     */
    public List<Venta> findByInvoiceNo(String search) {
        List<Venta> list = new ArrayList<>();
        for (Venta aux : csvList) {
            if (aux.getInvoiceNo().equals(search)) {
                list.add(aux);
            }
        }
        return list;
    }

    /**
     * Count by stock code string.
     *
     * @param stockCode the stock code
     * @return the string
     */
    public String countByStockCode(String stockCode) {

        String solution = "";

        int sellUnits = 0;
        for (int i = 0; i < csvList.size(); i++) {
            String stockCo = csvList.get(i).getStockCode();


            if (stockCode.equalsIgnoreCase(stockCo)) {

                int j = Integer.parseInt(csvList.get(i).getQuantity());
                sellUnits = sellUnits + j;

            }
        }

        System.out.println("la cantidad total de productos vendidos con el stockCode  " + stockCode + " es :  " + sellUnits);

        return solution;
    }

    /**
     * Avg monthlysales object.
     *
     * @param groupByCountry the group by country
     * @return the object
     */
    public String avgMonthlySales(boolean groupByCountry) {

        ArrayList<String> pais = new ArrayList();
        pais.add("");
        ArrayList<Float> totalByCountry = new ArrayList<Float>();
        totalByCountry.add((float) 0);
        int j = 1;
        int entrada = 0;

        if (groupByCountry == false) {

            float total = Summary();
            float avg = total / 12;
            String salida = "Promedio mensual: " + String.valueOf(avg);
            return salida;

        } else if (groupByCountry) {
            for (int i = 0; i < csvList.size(); i++) {
                Venta auxiliar = csvList.get(i);
                int index = pais.indexOf(auxiliar.getCountry());
                if (index == -1) {
                    pais.add(index + j, auxiliar.getCountry());
                    j++;
                }
            }
            for (int i = 0; i < csvList.size(); i++) {
                Venta aux = csvList.get(i);
                int index = pais.indexOf(aux.getCountry());

                float a = Float.parseFloat(aux.getQuantity());
                float b = Float.parseFloat(aux.getUnitPrice());

                float mul = a * b;
                if (index <= entrada) {
                    float total = totalByCountry.get(index) + mul;
                    totalByCountry.remove(index);
                    totalByCountry.add(index, total);
                } else {
                    entrada++;
                    float total = mul;
                    totalByCountry.add(index, total);
                }

            }

            float total = Summary();
            float average = total / 12;
            String salida = "Average Monthly Sales: " + String.valueOf(average) + "\n";

            for (int i = 0; i < totalByCountry.size(); i++) {
                float avg = totalByCountry.get(i) / 12;
                totalByCountry.remove(i);
                totalByCountry.add(i, avg);

                salida += pais.get(i) + ": " + totalByCountry.get(i) + "\n";
            }


            return salida;
        }

        return "";
    }

    /**
     * Gets csv list.
     *
     * @return the csv list
     */
    public List<Venta> getCsvList() {
        return csvList;
    }

    /**
     * Sets csv list.
     *
     * @param csvList the csv list
     */
    public void setCsvList(List<Venta> csvList) {
        this.csvList = csvList;
    }
}
