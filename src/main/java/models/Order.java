package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Order {

    private int id;
    private double total;
    private Set<Product> contents;

    public Order() {
    }

    public Order(double total) {
        this.total = total;
        this.contents = new HashSet<>();
    }

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

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    public Set<Product> getContents() {
        return contents;
    }

    public void setContents(Set<Product> contents) {
        this.contents = contents;
    }

<<<<<<< HEAD
=======
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
>>>>>>> ff432449f9a87ab8fb73e697547dac77633424a0
}
