package ru.yandex.practicum.product.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.product.dto.ProductDto;
import ru.yandex.practicum.product.dto.ProductPagableDto;
import ru.yandex.practicum.product.enums.ProductCategoryEnum;
import ru.yandex.practicum.product.request.SetProductQuantityState;
import ru.yandex.practicum.product.service.ProductService;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@Validated
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductDto> getProducts(@RequestParam ProductCategoryEnum productCategory,
                                        @Valid ProductPagableDto pageableDto) {
        return productService.getAll(productCategory, pageableDto);
    }

    @PutMapping
    public ProductDto createNewProduct(@RequestBody @Valid ProductDto productDto) {
        return productService.create(productDto);
    }

    @PostMapping
    public ProductDto updateProduct(@RequestBody @Valid ProductDto productDto) {
        return productService.update(productDto);
    }

    @PostMapping("/removeProductFromStore")
    public Boolean removeProductFromStore(@RequestBody @NotNull UUID productId) {
        return productService.remove(productId);
    }

    @PostMapping("/quantityState")
    public Boolean setProductQuantityState(@Valid SetProductQuantityState sr) {
        return productService.setQuantityState(sr);
    }

    @GetMapping("/{productId}")
    public ProductDto getProduct(@PathVariable @NotNull UUID productId) {
        return productService.getById(productId);
    }
}