package models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class User {

    private int id;
    private String name;
    private int distance;
    private String username;
    private Set<PreviousOrder> previousOrders;
    private double lifetimeSpend;
    private CurrentOrder basket;

    public User() {
    }

    public User(String name, String username, int distance) {
        this.name = name;
        this.distance = distance;
        this.username = username;
        this.lifetimeSpend = 0;
        this.previousOrders = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<PreviousOrder> getPreviousOrders() {
        return previousOrders;
    }

    public void setPreviousOrders(Set<PreviousOrder> previousOrders) {
        this.previousOrders = previousOrders;
    }

    public double getLifetimeSpend() {
        return lifetimeSpend;
    }

    public void setLifetimeSpend(double lifetimeSpend) {
        this.lifetimeSpend = lifetimeSpend;
    }

    public CurrentOrder getBasket() {
        return basket;
    }

    public void setBasket(CurrentOrder basket) {
        this.basket = basket;
    }

    public void addPreviousOrderToPreviousOrders(PreviousOrder previousOrder) {
        this.previousOrders.add(previousOrder);
    }

    public int checkPreviousOrdersSize() {
        return this.previousOrders.size();
    }
}
