package ar.edu.unq.desapp.grupoa.backenddesappapi.model.punctuationsystem;

import javax.persistence.*;

@Entity
@Table(name = "Products")
public class Product {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    private String name;
    private Double pointsNeeded;
    private String image;
    private Integer amountInStock;

    public Product() {
    }

    public Product(String name, Double pointsRequired, String image, Integer amountInStock) {
        this.name = name;
        this.pointsNeeded = pointsRequired;
        this.image = image;
        this.amountInStock = amountInStock;
    }

    public Product(Long id, String name, Double pointsRequired, String image, Integer amountInStock) {
        this.productId = id;
        this.name = name;
        this.pointsNeeded = pointsRequired;
        this.image = image;
        this.amountInStock = amountInStock;
    }

    public Double getPointsNeeded() {
        return this.pointsNeeded;
    }

    public String getName() {
        return this.name;
    }

    public String getImage() {
        return this.image;
    }

    public Integer getAmountInStock() {
        return this.amountInStock;
    }

    public void increaseStock(int amountToIncreaseStock) {
        this.amountInStock = amountToIncreaseStock + this.amountInStock;
    }

    public void decreaseStock(int amountToDecrease) {
        this.amountInStock = this.amountInStock - amountToDecrease;
    }

    public boolean thereIsStock() {
        return this.amountInStock != 0;
    }

    public void setPointNeeded(double pointNeeded) {
        this.pointsNeeded = pointNeeded;
    }

    public void setName(String newProductName) {
        this.name = newProductName;
    }

    public void setNewImage(String otherImage) {
        this.image = otherImage;
    }

    public void setNewAmountInStock(int amountInStock) {
        this.amountInStock = amountInStock;
    }

    public Long getId() {
        return this.productId;
    }

    public void setId(long l) {
        this.productId = l;
    }
}
