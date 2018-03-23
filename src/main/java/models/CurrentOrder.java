package models;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="current_orders")
public class CurrentOrder extends Order{

    private User user;

    public CurrentOrder() {
    }

    public CurrentOrder(double total, User user) {
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
