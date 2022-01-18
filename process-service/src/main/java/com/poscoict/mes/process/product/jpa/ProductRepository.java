package com.poscoict.mes.process.product.jpa;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
    Optional<ProductEntity> findByProductId(String productId);
}
