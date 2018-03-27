package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Purchase {

    private int id;
    private double total;
    private List<Product> contents;

    public Purchase() {
    }

    public Purchase(double total) {
        this.total = total;
        this.contents = new ArrayList<>();
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

    @Column(name="total")
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @OneToMany(mappedBy = "purchase", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    public List<Product> getContents() {
        return contents;
    }

    public void setContents(List<Product> contents) {
        this.contents = contents;
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

    public void increaseTotal(double price){
        total += price;
    }
    public void reduceTotal(double price){total -= price;}

    public void addToBasket(Product product){
        double totalPrice = product.getPrice() * product.getQuantity();
        addProductToContents(product);
        increaseTotal(totalPrice);
    }

    public void reduceTotalInBasket(Product product){
        double totalPrice = product.getPrice() * product.getQuantity();
        reduceTotal(totalPrice);
    }

    public void emptyContents() {
        this.contents.clear();
    }

}
