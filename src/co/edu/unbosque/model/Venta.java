package co.edu.unbosque.model;

/**
 * The type Venta.
 */
public class Venta {
    private String invoiceNo;
    private String stockCode;
    private String description;
    private String quantity;
    private String invoiceDate;
    private String unitPrice;
    private String customerId;
    private String country;

    /**
     * Instantiates a new Venta.
     *
     * @param invoiceNo   the invoice no
     * @param stockCode   the stock code
     * @param description the description
     * @param quantity    the quantity
     * @param invoiceDate the invoice date
     * @param unitPrice   the unit price
     * @param customerId  the customer id
     * @param country     the country
     */
    public Venta(String invoiceNo, String stockCode, String description, String quantity, String invoiceDate, String unitPrice, String customerId, String country) {
        this.invoiceNo = invoiceNo;
        this.stockCode = stockCode;
        this.description = description;
        this.quantity = quantity;
        this.invoiceDate = invoiceDate;
        this.unitPrice = unitPrice;
        this.customerId = customerId;
        this.country = country;
    }

    /**
     * Gets invoice no.
     *
     * @return the invoice no
     */
    public String getInvoiceNo() {
        return invoiceNo;
    }

    /**
     * Sets invoice no.
     *
     * @param invoiceNo the invoice no
     */
    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    /**
     * Gets stock code.
     *
     * @return the stock code
     */
    public String getStockCode() {
        return stockCode;
    }

    /**
     * Sets stock code.
     *
     * @param stockCode the stock code
     */
    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets quantity.
     *
     * @return the quantity
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * Sets quantity.
     *
     * @param quantity the quantity
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets invoice date.
     *
     * @return the invoice date
     */
    public String getInvoiceDate() {
        return invoiceDate;
    }

    /**
     * Sets invoice date.
     *
     * @param invoiceDate the invoice date
     */
    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    /**
     * Gets unit price.
     *
     * @return the unit price
     */
    public String getUnitPrice() {
        return unitPrice;
    }

    /**
     * Sets unit price.
     *
     * @param unitPrice the unit price
     */
    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * Gets customer id.
     *
     * @return the customer id
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Sets customer id.
     *
     * @param customerId the customer id
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets country.
     *
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets country.
     *
     * @param country the country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "invoiceNo='" + invoiceNo + '\'' +
                ", stockCode='" + stockCode + '\'' +
                ", description='" + description + '\'' +
                ", quantity='" + quantity + '\'' +
                ", invoiceDate='" + invoiceDate + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                ", customerId='" + customerId + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
