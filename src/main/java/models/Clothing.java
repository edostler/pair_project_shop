package models;

import java.util.GregorianCalendar;

public class Clothing extends Product {

    private ClothingCategory category;

    public Clothing() {
    }

    public Clothing(String name, ClothingCategory category, double price, int quantity, String description, GregorianCalendar stockDate) {
        super(name, price, quantity, description, stockDate);
        this.category = category;
    }

    public ClothingCategory getCategory() {
        return category;
    }

    public void setCategory(ClothingCategory category) {
        this.category = category;
    }
}
