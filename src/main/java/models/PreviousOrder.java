package models;

import javax.persistence.*;
import java.util.GregorianCalendar;


@Entity
@Table(name="previous_orders")
public class PreviousOrder extends Order{

    private User user;
    private GregorianCalendar orderDate;
    private GregorianCalendar deliveryDate;

    public PreviousOrder() {
    }


    public PreviousOrder(double total, User user, GregorianCalendar orderDate, GregorianCalendar deliveryDate) {
        super(total);
        this.user = user;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
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
}
