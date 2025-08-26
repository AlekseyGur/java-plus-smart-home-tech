package ru.yandex.practicum.interactionapi.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class ShoppingCartDto {
    @NotNull
    private UUID shoppingCartId;

    @NotNull
    @JsonDeserialize(using = CustomMapDeserializer.class)
    private Map<UUID, Integer> products;
}
