package ru.yandex.practicum.product.service;

import ru.yandex.practicum.product.dto.ProductDto;
import ru.yandex.practicum.product.dto.ProductPagableDto;
import ru.yandex.practicum.product.enums.ProductCategoryEnum;
import ru.yandex.practicum.product.request.SetProductQuantityState;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    List<ProductDto> getProducts(ProductCategoryEnum productCategory, ProductPagableDto pageableDto);

    ProductDto createNewProduct(ProductDto productDto);

    ProductDto updateProduct(ProductDto productDto);

    boolean removeProductFromStore(UUID productId);

    boolean setProductQuantityState(SetProductQuantityState setProductQuantityStateRequest);

    ProductDto getProduct(UUID productId);

    boolean existsById(UUID id);
}