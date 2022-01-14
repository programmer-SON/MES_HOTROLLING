package com.poscoict.mes.process.product.service;

import com.poscoict.mes.process.product.vo.ResponseProduct;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface ProductService {

    public List<ResponseProduct> getProducts();
}
