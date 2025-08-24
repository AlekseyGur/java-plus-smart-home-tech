package ru.yandex.practicum.product.enums;

public enum ProductQuantityStateEnum {
    ENDED, // — товар закончился;
    FEW, // — осталось меньше 10 единиц товара;
    ENOUGH, // — осталось от 10 до 100 единиц;
    MANY // — осталось больше 100 единиц.
}