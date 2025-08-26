package ru.yandex.practicum.interactionapi.dto;

import jakarta.validation.constraints.Min;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductPageDto {
    @Min(0)
    Integer page;
    @Min(1)
    Integer size;

    List<ProductPageSortInfoDto> sort;
    List<ProductDto> content;
}
