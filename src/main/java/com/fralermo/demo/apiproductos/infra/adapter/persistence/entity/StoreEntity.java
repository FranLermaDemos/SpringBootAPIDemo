package com.fralermo.demo.apiproductos.infra.adapter.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "stores")
@Data
public class StoreEntity {

    @Id
    @Column(name="store_id")
    private Long storeId;

    private String address;

}
