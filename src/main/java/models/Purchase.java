package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Purchase {

    private int id;
    private double total;
    private Set<Product> contents;

    public Purchase() {
    }

    public Purchase(double total) {
        this.total = total;
        this.contents = new HashSet<>();
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
    public Set<Product> getContents() {
        return contents;
    }

    public void setContents(Set<Product> contents) {
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

}
