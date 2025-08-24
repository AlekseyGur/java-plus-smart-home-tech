package ru.yandex.practicum.product.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import ru.yandex.practicum.product.enums.ProductCategoryEnum;
import ru.yandex.practicum.product.model.Product;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    @NonNull
    Page<Product> findAll(@NonNull Pageable pageable);

    List<Product> findAllByProductCategory(ProductCategoryEnum productCategory, Pageable pageRequest);
}