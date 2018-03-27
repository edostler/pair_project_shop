package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.GregorianCalendar;

@Entity
@Table(name="food_products")
public class Food extends Product {

    private FoodCategory category;

    public Food() {
    }

    public Food(String name, FoodCategory category, double price, int quantity, String description, GregorianCalendar stockDate, Shop shop) {
        super(name, price, quantity, description, stockDate, shop);
        this.category = category;
    }

    @Column(name="category")
    public FoodCategory getCategory() {
        return category;
    }

    public void setCategory(FoodCategory category) {
        this.category = category;
    }
}
