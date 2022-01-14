package com.poscoict.mes.process.order.service;

import com.poscoict.mes.process.company.service.CompanyService;
import com.poscoict.mes.process.company.vo.ResponseCompany;
import com.poscoict.mes.process.order.client.UserServiceClient;
import com.poscoict.mes.process.order.jpa.OrderRepository;
import com.poscoict.mes.process.order.vo.ResponseProductPlan;
import com.poscoict.mes.process.order.vo.ResponseUser;
import com.poscoict.mes.process.product.service.ProductService;
import com.poscoict.mes.process.product.vo.ResponseProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public ResponseProductPlan getProductPlan(String userId) {
        ResponseProductPlan plan = new ResponseProductPlan();

        List<ResponseCompany> companyList = companyService.getCompanies();
        List<ResponseProduct> productList = productService.getProducts();
        ResponseUser responseUser = userServiceClient.getUser(userId);

        plan.setCompanyList(companyList);
        plan.setProductList(productList);
        plan.setResponseUser(responseUser);

        return plan;
    }
}
