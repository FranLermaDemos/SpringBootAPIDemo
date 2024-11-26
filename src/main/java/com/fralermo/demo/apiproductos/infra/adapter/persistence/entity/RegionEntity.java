package com.fralermo.demo.apiproductos.infra.adapter.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "regions")
@Data
public class RegionEntity {

    @Id
    @Column(name="region_id")
    private Long regionId;

    @Column(name="region_code", unique = true, nullable = false)
    private String regionCode;

}
