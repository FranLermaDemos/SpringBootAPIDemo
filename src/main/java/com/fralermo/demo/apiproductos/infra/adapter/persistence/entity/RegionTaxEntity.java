package com.fralermo.demo.apiproductos.infra.adapter.persistence.entity;

import java.math.BigDecimal;

import com.fralermo.demo.apiproductos.domain.model.TaxType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "region_taxes")
@Data
public class RegionTaxEntity {

    @Id
    @Column(name="tax_id")
    private Long taxId;

    @Enumerated(EnumType.STRING)
    @Column(name="tax_type", nullable = false)
    private TaxType taxType;

    @Column(name="tax_percentage", nullable = false, precision = 5, scale = 2)
    private BigDecimal taxPercentage;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "region_id", nullable = false)
    private RegionEntity region;

}
