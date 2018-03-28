package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;


@Entity
@Table(name="previous_purchases")
public class PreviousPurchase extends Purchase {

    private Customer customer;
    private GregorianCalendar purchaseDate;
    private GregorianCalendar deliveryDate;
    private Shop shop;

    public PreviousPurchase() {
    }


    public PreviousPurchase(double total, Customer customer, GregorianCalendar purchaseDate, GregorianCalendar deliveryDate, Shop shop) {
        super(total);
        this.customer = customer;
        this.purchaseDate = purchaseDate;
        this.deliveryDate = deliveryDate;
        this.shop = shop;
    }

    @Column(name="purchase_date")
    public GregorianCalendar getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(GregorianCalendar purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Column(name="delivery_date")
    public GregorianCalendar getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(GregorianCalendar deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @ManyToOne
    @JoinColumn(name="customer_id", nullable = false)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    @JoinColumn(name="shop_id", nullable = false)
    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public String formatDateToString(GregorianCalendar date) {
        String day = Integer.toString(date.get(GregorianCalendar.DAY_OF_MONTH));
        String month = Integer.toString(date.get(GregorianCalendar.MONTH));
        String year = Integer.toString(date.get(GregorianCalendar.YEAR));
        String result = day + "/" + month + "/" +year;
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

    public double totalContentsOnly(List<Product> contents){
        double contentsTotal = 0.00;
        for (Product content : contents) {
            contentsTotal += (content.getPrice() * content.getQuantity());
        }
        return contentsTotal;
    }

}
