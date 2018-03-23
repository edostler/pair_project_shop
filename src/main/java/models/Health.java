package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.GregorianCalendar;

@Entity
@Table(name="health_products")
public class Health extends Product {

    private HealthCategory category;

    public Health() {
    }

    public Health(String name, HealthCategory category, double price, int quantity, String description, GregorianCalendar stockDate, Shop shop) {
        super(name, price, quantity, description, stockDate, shop);
        this.category = category;
    }

    @Column(name="category")
    public HealthCategory getCategory() {
        return category;
    }

    public void setCategory(HealthCategory category) {
        this.category = category;
    }
}
