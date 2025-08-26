package ru.yandex.practicum.interactionapi.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductPageSortInfoDto {
    private String direction;
    private String property;
}
