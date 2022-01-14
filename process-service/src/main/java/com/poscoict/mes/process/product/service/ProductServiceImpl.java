package com.poscoict.mes.process.product.service;


import com.poscoict.mes.process.product.jpa.ProductEntity;
import com.poscoict.mes.process.product.jpa.ProductRepository;
import com.poscoict.mes.process.product.vo.ResponseProduct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ResponseProduct> getProducts() {
        Iterable<ProductEntity> productList = productRepository.findAll();
        List<ResponseProduct> result = new ArrayList<>();

        productList.forEach(v -> {
            result.add(new ModelMapper().map(v, ResponseProduct.class));
        });
        return result;
    }
}
