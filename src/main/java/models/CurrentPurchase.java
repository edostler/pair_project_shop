package models;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="current_purchases")
public class CurrentPurchase extends Purchase {

    private User user;

    public CurrentPurchase() {
    }

    public CurrentPurchase(double total, User user) {
        super(total);
        this.user = user;
    }

    @OneToOne(fetch = FetchType.LAZY)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
