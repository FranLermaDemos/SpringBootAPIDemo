package com.fralermo.demo.apiproductos.infra.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.fralermo.demo.apiproductos.domain.model.StorePrice;
import com.fralermo.demo.apiproductos.infra.adapter.persistence.entity.StorePriceEntity;

@Mapper(componentModel = "spring")
public interface StorePriceMapper {
	
	StorePriceMapper INSTANCE = Mappers.getMapper(StorePriceMapper.class);

	
	@Mapping(source = "id", target = "store.storeId")
    StorePrice toModel(StorePriceEntity entity);
	
	@Mapping(source = "store.storeId", target = "id")
    StorePriceEntity toEntity(StorePrice model);
}

