package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="shops")
public class Shop {

    private int id;
    private String name;
    private Set<PreviousOrder> allOrders;
    private Set<Product> stock;
    private Set<User> users;

    public Shop() {
    }

    public Shop(String name) {
        this.name = name;
        this.allOrders = new HashSet<>();
        this.stock = new HashSet<>();
        this.users = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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

    @OneToMany(mappedBy="shop", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    public Set<PreviousOrder> getAllOrders() {
        return allOrders;
    }

    public void setAllOrders(Set<PreviousOrder> allOrders) {
        this.allOrders = allOrders;
    }

    @OneToMany(mappedBy = "shop", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    public Set<Product> getStock() {
        return stock;
    }

    public void setStock(Set<Product> stock) {
        this.stock = stock;
    }

    @OneToMany(mappedBy = "shop", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
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
