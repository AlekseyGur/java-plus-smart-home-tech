package ru.yandex.practicum.product.service;

import ru.yandex.practicum.product.dto.ProductDto;
import ru.yandex.practicum.product.dto.ProductPagableDto;
import ru.yandex.practicum.product.enums.ProductCategoryEnum;
import ru.yandex.practicum.product.request.SetProductQuantityState;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    List<ProductDto> getAll(ProductCategoryEnum productCategory, ProductPagableDto pageableDto);

    ProductDto create(ProductDto productDto);

    ProductDto update(ProductDto productDto);

    boolean remove(UUID productId);

    boolean setQuantityState(SetProductQuantityState setProductQuantityStateRequest);

    ProductDto getById(UUID productId);

    boolean existsById(UUID id);
}