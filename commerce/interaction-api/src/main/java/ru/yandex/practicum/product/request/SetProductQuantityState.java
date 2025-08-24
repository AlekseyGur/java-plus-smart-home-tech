package ru.yandex.practicum.product.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.yandex.practicum.product.enums.ProductQuantityStateEnum;

import java.util.UUID;

@Getter
@Setter
@ToString
public class SetProductQuantityState {
    @NotNull
    UUID productId;

    @NotNull
    ProductQuantityStateEnum quantityState;
}