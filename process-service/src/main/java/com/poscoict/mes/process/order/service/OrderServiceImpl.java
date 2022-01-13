package com.poscoict.mes.process.order.service;

import com.poscoict.mes.process.company.service.CompanyService;
import com.poscoict.mes.process.order.client.UserServiceClient;
import com.poscoict.mes.process.order.jpa.OrderRepository;
import com.poscoict.mes.process.order.vo.ResponseProductPlan;
import com.poscoict.mes.process.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderServiceImpl implements OrderService{

    OrderRepository orderRepository;
    CompanyService companyService;
    ProductService productService;
    UserServiceClient userServiceClient;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, CompanyService companyService, ProductService productService, UserServiceClient userServiceClient) {
        this.orderRepository = orderRepository;
        this.companyService = companyService;
        this.productService = productService;
        this.userServiceClient = userServiceClient;
    }

    @Override
    public List<ResponseProductPlan> getProductPlan() {
        return null;
    }
}
