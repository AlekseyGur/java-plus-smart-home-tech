package ru.yandex.practicum.product.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.yandex.practicum.product.enums.ProductActiveStateEnum;
import ru.yandex.practicum.product.enums.ProductCategoryEnum;
import ru.yandex.practicum.product.enums.ProductQuantityStateEnum;

import java.util.UUID;

@Getter
@Setter
@ToString
public class ProductDto {
    UUID id;

    @NotBlank
    String name;

    @NotBlank
    String description;

    String imageSrc;

    @Min(value = 0, message = "Цена должна быть положительной")
    Double price;

    @Min(1)
    @Max(5)
    Integer rating;

    ProductActiveStateEnum state;
    ProductQuantityStateEnum quantityState;
    ProductCategoryEnum category;
}