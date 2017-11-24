package com.georgebotas.inventory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

    public Product() { }

    public Product(String name, String type, int price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    private String name;
    private String type;
    private int price;
    private int stock;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long product_id;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public int getPrice() { return price; }

    public void setPrice(int price) { this.price = price; }

    public int getStock() { return stock; }

    public void setStock(int stock) { this.stock = stock; }

    public Long getProduct_id() { return product_id; }

    public void setProduct_id(Long product_id) { this.product_id = product_id; }

}
