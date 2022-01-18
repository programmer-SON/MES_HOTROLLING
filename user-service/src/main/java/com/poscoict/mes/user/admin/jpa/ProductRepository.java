package com.poscoict.mes.user.admin.jpa;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<ProductEntity,Long> {

    //void deleteByProductId(String productId);
    Optional<ProductEntity> findByProductId(String productId);
}
