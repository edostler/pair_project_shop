package models;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="current_purchases")
public class CurrentPurchase extends Purchase {

    private Customer customer;

    public CurrentPurchase() {
    }

    public CurrentPurchase(double total, Customer customer) {
        super(total);
        this.customer = customer;
    }

    @OneToOne(fetch = FetchType.LAZY)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
