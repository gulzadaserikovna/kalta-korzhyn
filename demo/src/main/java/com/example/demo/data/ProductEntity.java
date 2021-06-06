package com.example.demo.data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "product")

public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String nameRu;
    @Column
    private String nameKz;
    @Column(length = 20000)
    private String description;
    @Column
    private Double price;
    @Column(updatable = false)
    private Date createDate;
    @Column
    private Date updateDate;
    @Column
    private Date deleteDate;

    @OneToMany(mappedBy = "productEntity", fetch = FetchType.LAZY)
    private List<ProductImgEntity> productImgs;

    public ProductEntity(long id, String nameRu, String nameKz, String description, Double price, Date createDate, Date updateDate, Date deleteDate) {
        this.id = id;
        this.nameRu = nameRu;
        this.nameKz = nameKz;
        this.description = description;
        this.price = price;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.deleteDate = deleteDate;
    }

    public ProductEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    public String getNameKz() {
        return nameKz;
    }

    public void setNameKz(String nameKz) {
        this.nameKz = nameKz;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }

    public List<ProductImgEntity> getProductImgs() {
        return productImgs;
    }

    public void setProductImgs(List<ProductImgEntity> productImgs) {
        this.productImgs = productImgs;
    }
}
