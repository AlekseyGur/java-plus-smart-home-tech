package ru.yandex.practicum.interactionapi.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.yandex.practicum.interactionapi.enums.QuantityState;

import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class SetProductQuantityStateRequest {
    @NotNull
    UUID productId;
    
    @NotNull
    QuantityState quantityState;
}
