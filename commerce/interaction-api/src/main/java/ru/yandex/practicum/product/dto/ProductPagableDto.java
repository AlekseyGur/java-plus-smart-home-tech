package ru.yandex.practicum.product.dto;

import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ProductPagableDto {
    @Min(0)
    Integer page;
    @Min(1)
    Integer size;
    List<String> sort;
}