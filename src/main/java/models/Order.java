package models;

import java.util.HashSet;
import java.util.Set;

public abstract class Order {

    private int id;
    private double total;
    private Set<Product> contents;
    private User user;

    public Order(User user) {
        this.total = 0;
        this.user = user;
        this.contents = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Set<Product> getContents() {
        return contents;
    }

    public void setContents(Set<Product> contents) {
        this.contents = contents;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addProductToContents(Product product) {
        this.contents.add(product);
    }

    public int checkContentsSize() {
        return this.contents.size();
    }

    public void removeProductFromContents(Product product) {
        this.contents.remove(product);
    }
}
