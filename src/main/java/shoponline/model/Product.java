package shoponline.model;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    @Column(length = 500)
    private String description;

    @Column(length = 50)
    private String category;

    // AM ȘTERS CÂMPUL 'imageUrl' DE AICI

    public Product() {
    }

    // CONSTRUCTORUL ACTUALIZAT (ARE ACUM 4 PARAMETRI, FĂRĂ POZĂ)
    public Product(String name, Double price, String description, String category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    // Getteri și Setteri

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // AM ȘTERS GETTER ȘI SETTER PENTRU 'imageUrl'
}