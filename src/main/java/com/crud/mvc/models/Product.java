package com.crud.mvc.models;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;

    private String title;

    private String description;

    private Double price;

    private String categoryID;

    public Product(){}

    public Product(String title, String description, Double price, String categoryID) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.categoryID = categoryID;
    }

    public Product(String id, String title, String description, Double price, String categoryID) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.categoryID = categoryID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", categoryID='" + categoryID + '\'' +
                '}';
    }
}
