package com.fralermo.demo.apiproductos.infra.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.fralermo.demo.apiproductos.domain.model.Product;
import com.fralermo.demo.apiproductos.infra.adapter.persistence.entity.ProductEntity;

@Mapper(componentModel = "spring", uses = {RegionTaxMapper.class, StorePriceMapper.class})
public interface ProductMapper {

	RegionTaxMapper regionTaxMapper = Mappers.getMapper(RegionTaxMapper.class);
	StorePriceMapper storePriceMapper = Mappers.getMapper(StorePriceMapper.class);
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "productId", target = "id")
    @Mapping(source = "productDescription", target = "description")
    Product toModel(ProductEntity entity);

    @Mapping(source = "id", target = "productId")
    @Mapping(source = "description", target = "productDescription")
    ProductEntity toEntity(Product model);
}
