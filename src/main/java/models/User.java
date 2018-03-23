package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
public class User {

    private int id;
    private String name;
    private int distance;
    private String username;
    private Set<PreviousOrder> previousOrders;
    private double lifetimeSpend;
    private CurrentOrder basket;
    private Shop shop;

    public User() {
    }

    public User(String name, String username, int distance, Shop shop) {
        this.name = name;
        this.distance = distance;
        this.username = username;
        this.lifetimeSpend = 0;
        this.previousOrders = new HashSet<>();
        this.shop = shop;
    }

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

    @Column(name="distance")
    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Column(name="username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    public Set<PreviousOrder> getPreviousOrders() {
        return previousOrders;
    }

    public void setPreviousOrders(Set<PreviousOrder> previousOrders) {
        this.previousOrders = previousOrders;
    }

    @Column(name="lifetime_spend")
    public double getLifetimeSpend() {
        return lifetimeSpend;
    }

    public void setLifetimeSpend(double lifetimeSpend) {
        this.lifetimeSpend = lifetimeSpend;
    }

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    public CurrentOrder getBasket() {
        return basket;
    }

    public void setBasket(CurrentOrder basket) {
        this.basket = basket;
    }

<<<<<<< HEAD
    @ManyToOne
    @JoinColumn(name="shop_id", nullable = false)
    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
=======
    public void addPreviousOrderToPreviousOrders(PreviousOrder previousOrder) {
        this.previousOrders.add(previousOrder);
    }

    public int checkPreviousOrdersSize() {
        return this.previousOrders.size();
>>>>>>> ff432449f9a87ab8fb73e697547dac77633424a0
    }
}
