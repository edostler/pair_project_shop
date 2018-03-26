package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="customers")
public class Customer {

    private int id;
    private String name;
    private int distance;
    private String username;
    private Set<PreviousPurchase> previousPurchases;
    private double lifetimeSpend;
    private CurrentPurchase basket;
    private Shop shop;

    public Customer() {
    }

    public Customer(String name, String username, int distance, Shop shop) {
        this.name = name;
        this.distance = distance;
        this.username = username;
        this.lifetimeSpend = 0;
        this.previousPurchases = new HashSet<>();
        this.basket = null;
        this.shop = shop;
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

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    public Set<PreviousPurchase> getPreviousPurchases() {
        return previousPurchases;
    }

    public void setPreviousPurchases(Set<PreviousPurchase> previousPurchases) {
        this.previousPurchases = previousPurchases;
    }

    @Column(name="lifetime_spend")
    public double getLifetimeSpend() {
        return lifetimeSpend;
    }

    public void setLifetimeSpend(double lifetimeSpend) {
        this.lifetimeSpend = lifetimeSpend;
    }

    @OneToOne(mappedBy = "customer", fetch = FetchType.LAZY)
    public CurrentPurchase getBasket() {
        return basket;
    }

    public void setBasket(CurrentPurchase basket) {
        this.basket = basket;
    }

    @ManyToOne
    @JoinColumn(name="shop_id", nullable = false)
    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public void addPreviousPurchaseToPreviousPurchases(PreviousPurchase previousPurchase) {
        this.previousPurchases.add(previousPurchase);
    }

    public int checkPreviousPurchasesSize() {
        return this.previousPurchases.size();
    }
}
