package models;

import java.util.HashSet;
import java.util.Set;

public class Shop {

    private int id;
    private String name;
    private Set<PreviousOrder> allOrders;
    private Set<Product> stock;

    public Shop(String name) {
        this.name = name;
        this.allOrders = new HashSet<>();
        this.stock = new HashSet<>();
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

    public Set<PreviousOrder> getAllOrders() {
        return allOrders;
    }

    public void setAllOrders(Set<PreviousOrder> allOrders) {
        this.allOrders = allOrders;
    }

    public Set<Product> getStock() {
        return stock;
    }

    public void setStock(Set<Product> stock) {
        this.stock = stock;
    }

    public void addProductToStock(Product product) {
        this.stock.add(product);
    }

    public void addPreviousOrderToAllOrders(PreviousOrder previousOrder) {
        this.allOrders.add(previousOrder);
    }

    public int checkStockSize() {
        return this.stock.size();
    }

    public int checkAllOrdersSize() {
        return this.allOrders.size();
    }

    public void removeProductFromStock(Product product) {
        this.stock.remove(product);
    }

}
