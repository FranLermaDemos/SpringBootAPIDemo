package com.fralermo.demo.apiproductos.infra.adapter.persistence.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "products") 
@Data
public class ProductEntity {

    @Id
    @Column(name="product_id")
    private Long productId;

    private String productDescription;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StorePriceEntity> prices;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RegionTaxEntity> taxes;

}
