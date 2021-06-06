package com.example.demo.data;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity(name = "product_image")
public class ProductImgEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private String link;

    @JoinColumn (name="product_id")
    @JsonIgnore
    @ManyToOne
    private ProductEntity productEntity;

    public ProductImgEntity(Long id, String name, String link, ProductEntity productEntity) {
        this.id = id;
        this.name = name;
        this.link = link;
        this.productEntity = productEntity;
    }

    public ProductImgEntity() {
    }

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) { this.link = link; }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }
}

