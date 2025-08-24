package ru.yandex.practicum.product.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.yandex.practicum.product.enums.ProductActiveStateEnum;
import ru.yandex.practicum.product.enums.ProductCategoryEnum;
import ru.yandex.practicum.product.enums.ProductQuantityStateEnum;

import java.util.UUID;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    String name;
    String description;
    String imageSrc;
    double price;
    int rating;

    @Enumerated(EnumType.STRING)
    ProductActiveStateEnum state;

    @Enumerated(EnumType.STRING)
    ProductQuantityStateEnum quantityState;

    @Enumerated(EnumType.STRING)
    ProductCategoryEnum category;
}