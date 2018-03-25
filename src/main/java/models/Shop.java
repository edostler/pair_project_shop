package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="shops")
public class Shop {

    private int id;
    private String name;
    private Set<PreviousPurchase> allPurchases;
    private Set<Product> stock;
    private Set<Customer> customers;

    public Shop() {
    }

    public Shop(String name) {
        this.name = name;
        this.allPurchases = new HashSet<>();
        this.stock = new HashSet<>();
        this.customers = new HashSet<>();
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
    public Set<PreviousPurchase> getAllPurchases() {
        return allPurchases;
    }

    public void setAllPurchases(Set<PreviousPurchase> allPurchases) {
        this.allPurchases = allPurchases;
    }

    @OneToMany(mappedBy = "shop", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    public Set<Product> getStock() {
        return stock;
    }

    public void setStock(Set<Product> stock) {
        this.stock = stock;
    }

    @OneToMany(mappedBy = "shop", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public void addProductToStock(Product product) {
        this.stock.add(product);
    }

    public void addPreviousPurchaseToAllPurchases(PreviousPurchase previousPurchase) {
        this.allPurchases.add(previousPurchase);
    }

    public int checkStockSize() {
        return this.stock.size();
    }

    public int checkAllPurchasesSize() {
        return this.allPurchases.size();
    }

    public void removeProductFromStock(Product product) {
        this.stock.remove(product);
    }


}
