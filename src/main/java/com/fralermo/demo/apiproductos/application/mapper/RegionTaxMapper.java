package com.fralermo.demo.apiproductos.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fralermo.demo.apiproductos.domain.model.RegionTax;
import com.fralermo.demo.apiproductos.infra.adapter.persistence.entity.RegionTaxEntity;

@Mapper(componentModel = "spring")
public interface RegionTaxMapper {
	
	RegionTaxMapper INSTANCE = Mappers.getMapper(RegionTaxMapper.class);

    RegionTax toModel(RegionTaxEntity entity);	
    RegionTaxEntity toEntity(RegionTax model);
}
