package models;

import java.util.GregorianCalendar;

public class Health extends Product {

    private HealthCategory category;

    public Health() {
    }

    public Health(String name, HealthCategory category, double price, int quantity, String description, GregorianCalendar stockDate) {
        super(name, price, quantity, description, stockDate);
        this.category = category;
    }

    public HealthCategory getCategory() {
        return category;
    }

    public void setCategory(HealthCategory category) {
        this.category = category;
    }
}
