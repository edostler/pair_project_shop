package models;

import java.util.GregorianCalendar;

public class PreviousOrder extends Order{

    private GregorianCalendar orderDate;
    private GregorianCalendar deliveryDate;

    public PreviousOrder(User user, GregorianCalendar orderDate, GregorianCalendar deliveryDate) {
        super(user);
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
    }

    public GregorianCalendar getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(GregorianCalendar orderDate) {
        this.orderDate = orderDate;
    }

    public GregorianCalendar getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(GregorianCalendar deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
