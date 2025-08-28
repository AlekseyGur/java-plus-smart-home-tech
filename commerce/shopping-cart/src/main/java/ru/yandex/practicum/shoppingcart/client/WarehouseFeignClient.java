package ru.yandex.practicum.shoppingcart.client;

import org.springframework.cloud.openfeign.FeignClient;
import ru.yandex.practicum.interactionapi.feign.WarehouseClient;

@FeignClient(name = "warehouse")
public interface WarehouseFeignClient extends WarehouseClient {
}