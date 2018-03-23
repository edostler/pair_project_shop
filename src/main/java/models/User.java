package models;

import java.util.ArrayList;

public class User {

    private int id;
    private String name;
    private int distance;
    private String username;
    private ArrayList<PreviousOrder> previousOrders;
    private double lifetimeSpend;
    private CurrentOrder basket;

    public User() {
    }

    public User(String name, int distance, String username) {
        this.name = name;
        this.distance = distance;
        this.username = username;
        this.lifetimeSpend = 0;
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

    public ArrayList<PreviousOrder> getPreviousOrders() {
        return previousOrders;
    }

    public void setPreviousOrders(ArrayList<PreviousOrder> previousOrders) {
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
}
