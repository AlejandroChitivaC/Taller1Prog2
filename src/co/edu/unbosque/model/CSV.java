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

    public Object avgMonthlysales(boolean groupByCountry) {
        Calendar calendar = new GregorianCalendar();

        double[] monthValues = new double[12];
        int[] counter = new int[12];
        HashMap<String, double[]> paisValues = new HashMap<>();
        HashMap<String, int[]> paisValuesCounter = new HashMap<>();

        if (groupByCountry) {
            for (int i = 0; i < csvList.size(); i++) {
                Date transDate;
                try {
                    transDate = CORREC_DATE_FORMAT.parse(csvList.get(i).getInvoiceDate());
                    calendar.setTime(transDate);
                    int month = calendar.get(Calendar.MONTH);
                    Double actualSale = Double.parseDouble(csvList.get(i).getQuantity()) * Double.parseDouble(csvList.get(i).getUnitPrice());
                    String Pais = csvList.get(i).getCountry();
                    var countrymonthValues = paisValues.get(Pais);
                    var paismonthValuesCounter = paisValuesCounter.get(Pais);
                    if (countrymonthValues == null) {
                        paisValues.put(Pais, new double[12]);
                        paisValuesCounter.put(Pais, new int[12]);
                        i--;
                    } else {
                        countrymonthValues[month] += actualSale;
                        paismonthValuesCounter[month]++;
                        paisValues.put(Pais, countrymonthValues);
                        paisValuesCounter.put(Pais, paismonthValuesCounter);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                calendar.setTime(transDate);
            }


            /**
             * Gets csv list.
             *
             * @return the csv list
             */
         /*   public List<Venta> getCsvList () {
                return csvList;
            }


            /**
             * Sets csv list.
             *
             * @param csvList the csv list
             */
            /*public void setCsvList(List < Venta > csvList) {
                this.csvList = csvList;
            }*/
        }/*
