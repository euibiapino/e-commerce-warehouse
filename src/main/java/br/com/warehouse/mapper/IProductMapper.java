package br.com.warehouse.mapper;

import br.com.warehouse.dto.ProductStoreFrontSaveDTO;
import br.com.warehouse.entity.ProductEntity;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IProductMapper {

    ProductStoreFrontSaveDTO toDTO(final ProductEntity entity);

}
