package models;

import javax.persistence.*;
import java.util.GregorianCalendar;


@Entity
@Table(name="previous_purchases")
public class PreviousPurchase extends Purchase {

    private User user;
    private GregorianCalendar orderDate;
    private GregorianCalendar deliveryDate;
    private Shop shop;

    public PreviousPurchase() {
    }


    public PreviousPurchase(double total, User user, GregorianCalendar orderDate, GregorianCalendar deliveryDate, Shop shop) {
        super(total);
        this.user = user;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.shop = shop;
    }

    @Column(name="order_date")
    public GregorianCalendar getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(GregorianCalendar orderDate) {
        this.orderDate = orderDate;
    }

    @Column(name="delivery_date")
    public GregorianCalendar getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(GregorianCalendar deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
}
