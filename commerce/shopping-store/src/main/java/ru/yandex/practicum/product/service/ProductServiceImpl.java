package ru.yandex.practicum.product.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yandex.practicum.product.dto.ProductDto;
import ru.yandex.practicum.product.dto.ProductPagableDto;
import ru.yandex.practicum.product.enums.ProductActiveStateEnum;
import ru.yandex.practicum.product.enums.ProductCategoryEnum;
import ru.yandex.practicum.product.mapper.ProductMapper;
import ru.yandex.practicum.product.model.Product;
import ru.yandex.practicum.product.repository.ProductRepository;
import ru.yandex.practicum.product.request.SetProductQuantityState;
import ru.yandex.practicum.system.exception.NotFoundException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ProductDto> getAll(ProductCategoryEnum productCategory, ProductPagableDto pageableDto) {
        Pageable pageRequest = PageRequest.of(pageableDto.getPage(), pageableDto.getSize(),
                Sort.by(Sort.DEFAULT_DIRECTION, String.join(",", pageableDto.getSort())));

        return productRepository.findAllByProductCategory(productCategory, pageRequest)
                .stream()
                .map(productMapper::toDto)
                .toList();
    }

    @Override
    public ProductDto create(ProductDto productDto) {
        Product newProduct = productMapper.fromDto(productDto);
        return productMapper.toDto(productRepository.save(newProduct));
    }

    @Override
    public ProductDto update(ProductDto productDto) {
        Product oldProduct = productRepository.findById(productDto.getId())
                .orElseThrow(() -> new NotFoundException("Товар не найден"));

        Product newProduct = productMapper.fromDto(productDto);
        newProduct.setId(oldProduct.getId());
        return productMapper.toDto(productRepository.save(newProduct));
    }

    @Override
    public boolean remove(UUID productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Товар не найден"));

        product.setState(ProductActiveStateEnum.DEACTIVATE);
        return true;
    }

    @Override
    public boolean setQuantityState(SetProductQuantityState setProductQuantityStateRequest) {
        Product product = productRepository.findById(setProductQuantityStateRequest.getProductId())
                .orElseThrow(() -> new NotFoundException("Товар не найден"));

        product.setQuantityState(setProductQuantityStateRequest.getQuantityState());
        return true;
    }

    @Override
    public ProductDto getById(UUID productId) {
        return productRepository.findById(productId)
                .map(productMapper::toDto)
                .orElseThrow(() -> new NotFoundException("Товар не найден"));
    }

    @Override
    public boolean existsById(UUID productId) {
        return productRepository.existsById(productId);
    }
}