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

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

    @Column(name = "imageSrc")
    String imageSrc;

    @Column(name = "price")
    double price;

    @Column(name = "rating")
    int rating;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    ProductActiveStateEnum state;

    @Enumerated(EnumType.STRING)
    @Column(name = "quantity_state")
    ProductQuantityStateEnum quantityState;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    ProductCategoryEnum category;

}