package models;

import javax.persistence.*;
import java.util.GregorianCalendar;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Product {

    private int id;
    private String name;
    private double price;
    private boolean availability;
    private int quantity;
    private String description;
    private GregorianCalendar stockDate;
    private Shop shop;
    private Purchase purchase;
    private String image;


    public Product() {
    }

    public Product(String name, double price, int quantity, String description, GregorianCalendar stockDate, Shop shop) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.stockDate = stockDate;
        this.shop = shop;
        this.purchase = null;
        this.availability = checkAvailability();
        this.image = null;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Column(name="availability")
    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Column(name="quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Column(name="description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name="stock_date")
    public GregorianCalendar getStockDate() {
        return stockDate;
    }

    public void setStockDate(GregorianCalendar stockDate) {
        this.stockDate = stockDate;
    }

    @ManyToOne
    @JoinColumn(name="shop_id", nullable = false)
    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    @ManyToOne
    @JoinColumn(name="purchase_id", nullable = true)
    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public boolean checkAvailability() {
        if (this.quantity > 0) {
            return true;
        }
        return false;
    }

    @Column(name="image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String formatDateToString(GregorianCalendar date) {
        String day = Integer.toString(date.get(GregorianCalendar.DAY_OF_MONTH));
        String month = Integer.toString(date.get(GregorianCalendar.MONTH));
        String year = Integer.toString(date.get(GregorianCalendar.YEAR));
        String result = day + "/" + month + "/" +year;
        return result;
    }

    public double calculateQuantityPrice() {
        double result = this.quantity * this.price;
        return result;
    }

    public String formatDateToStringForInput(GregorianCalendar date) {
        String day = "";
        String month = "";

        int dayInt = date.get(GregorianCalendar.DAY_OF_MONTH);
        String dayStr = Integer.toString(dayInt);
        if (dayInt < 10) {
            day = "0" + dayStr;
        }
        else {
            day = dayStr;
        }

        int monthInt = date.get(GregorianCalendar.MONTH);
        String monthStr = Integer.toString(monthInt);
        if (monthInt < 10) {
            month = "0" + monthStr;
        }
        else {
            month = monthStr;
        }

        String year = Integer.toString(date.get(GregorianCalendar.YEAR));

        String result = year + "-" + month + "-" + day;
        return result;
    }

}
