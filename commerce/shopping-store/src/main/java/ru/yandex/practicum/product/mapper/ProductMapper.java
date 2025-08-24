package ru.yandex.practicum.product.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.yandex.practicum.product.dto.ProductDto;
import ru.yandex.practicum.product.model.Product;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    ProductDto toDto(Product product);

    Product fromDto(ProductDto productDto);

    List<ProductDto> toDto(List<Product> products);
}