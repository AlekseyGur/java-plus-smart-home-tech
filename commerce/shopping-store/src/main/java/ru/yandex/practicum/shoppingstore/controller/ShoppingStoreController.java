package ru.yandex.practicum.shoppingstore.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.interactionapi.dto.PageableDto;
import ru.yandex.practicum.interactionapi.dto.ProductDto;
import ru.yandex.practicum.interactionapi.enums.ProductCategory;
import ru.yandex.practicum.interactionapi.request.SetProductQuantityStateRequest;
import ru.yandex.practicum.shoppingstore.service.ShoppingStoreService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/shopping-store")
@RequiredArgsConstructor
public class ShoppingStoreController {

    private final ShoppingStoreService shoppingStoreService;

    @GetMapping
    public List<ProductDto> getProducts(@RequestParam ProductCategory productCategory,
                                        @Valid PageableDto pageableDto) {
        return shoppingStoreService.getProducts(productCategory, pageableDto);
    }

    @PutMapping
    public ProductDto createNewProduct(@RequestBody @Valid ProductDto productDto) {
        return shoppingStoreService.createNewProduct(productDto);
    }

    @PostMapping
    public ProductDto updateProduct(@RequestBody @Valid ProductDto productDto) {
        return shoppingStoreService.updateProduct(productDto);
    }

    @PostMapping("/removeProductFromStore")
    public Boolean removeProductFromStore(@RequestBody @NotNull UUID productId) {
        return shoppingStoreService.removeProductFromStore(productId);
    }

    @PostMapping("/quantityState")
    public Boolean setProductQuantityState(@Valid SetProductQuantityStateRequest setProductQuantityStateRequest) {
        return shoppingStoreService.setProductQuantityState(setProductQuantityStateRequest);
    }

    @GetMapping("/{productId}")
    public ProductDto getProduct(@PathVariable @NotNull UUID productId) {
        return shoppingStoreService.getProduct(productId);
    }
}
