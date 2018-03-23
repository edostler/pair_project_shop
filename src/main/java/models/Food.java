package models;

import java.util.GregorianCalendar;

public class Food extends Product {

    private FoodCategory category;

    public Food() {
    }

    public Food(String name, FoodCategory category, double price, int quantity, String description, GregorianCalendar stockDate) {
        super(name, price, quantity, description, stockDate);
        this.category = category;
    }

    public FoodCategory getCategory() {
        return category;
    }

    public void setCategory(FoodCategory category) {
        this.category = category;
    }
}
