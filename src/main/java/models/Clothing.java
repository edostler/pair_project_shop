package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.GregorianCalendar;

@Entity
@Table(name="clothing-products")
public class Clothing extends Product {

    private ClothingCategory category;

    public Clothing() {
    }

    public Clothing(String name, ClothingCategory category, double price, int quantity, String description, GregorianCalendar stockDate, Shop shop) {
        super(name, price, quantity, description, stockDate, shop);
        this.category = category;
    }

    @Column(name="category")
    public ClothingCategory getCategory() {
        return category;
    }

    public void setCategory(ClothingCategory category) {
        this.category = category;
    }
}
