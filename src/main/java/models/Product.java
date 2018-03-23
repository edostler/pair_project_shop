package models;

import java.util.GregorianCalendar;

public abstract class Product {

    private int id;
    private String name;
    private double price;
    private boolean availability;
    private int quantity;
    private String description;
    private GregorianCalendar stockDate;


    public Product() {
    }

    public Product(String name, double price, int quantity, String description, GregorianCalendar stockDate) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.stockDate = stockDate;
        getAvailability();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GregorianCalendar getStockDate() {
        return stockDate;
    }

    public void setStockDate(GregorianCalendar stockDate) {
        this.stockDate = stockDate;
    }

    public boolean getAvailability() {
        if (quantity > 0) {
            return true;
        }
        return false;
    }
}
