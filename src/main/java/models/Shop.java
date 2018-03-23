package models;

import java.util.HashSet;
import java.util.Set;

public class Shop {

    private int id;
    private String name;
    private Set<Order> allOrders;

    public Shop(String name) {
        this.name = name;
        this.allOrders = new HashSet<>();
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

    public Set<Order> getAllOrders() {
        return allOrders;
    }

    public void setAllOrders(Set<Order> allOrders) {
        this.allOrders = allOrders;
    }

}
