package com.poscoict.mes.process.order;

import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

import com.poscoict.mes.process.company.jpa.CompanyEntity;
import com.poscoict.mes.process.company.jpa.CompanyRepository;
import com.poscoict.mes.process.company.service.CompanyService;
import com.poscoict.mes.process.company.vo.ResponseCompany;
import com.poscoict.mes.process.order.client.UserServiceClient;
import com.poscoict.mes.process.order.service.OrderService;
import com.poscoict.mes.process.order.vo.ResponseProductPlan;
import com.poscoict.mes.process.order.vo.ResponseUser;
import com.poscoict.mes.process.product.jpa.ProductEntity;
import com.poscoict.mes.process.product.jpa.ProductRepository;
import com.poscoict.mes.process.product.service.ProductService;
import com.poscoict.mes.process.product.vo.ResponseProduct;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@SpringBootTest
@Slf4j
class OrderTest {

//	OrderRepository orderRepository;
	UserServiceClient userServiceClient;

	CompanyService companyService;
	ProductService productService;

	@Autowired
	public OrderTest( UserServiceClient userServiceClient,
					 CompanyService companyService,
					 ProductService productService) {

		this.userServiceClient = userServiceClient;
		this.companyService = companyService;
		this.productService = productService;
	}



	/*
	@Test
	@DisplayName("insertOrder")
	void insertOrder() {
		
		IntStream.range(1, 10).forEach(i -> {
			OrderEntity entity = new OrderEntity();
			entity.setOrderId("A1234" + i);
			entity.setUserId("sjw"+i);
			entity.setProductId("B1234" + i);
			entity.setCompanyId("C1234"+i);
			entity.setProcessStart(new Date());
			entity.setProcessEnd(new Date());
			entity.setRegdate(new Date());
			entity.setStockPlan(200);
			if(i % 2 == 0) {
				entity.setStatus("진행중");
			}else {
				entity.setStatus("완료");
			}
			orderRepository.save(entity);
		});	
	}

	@Test
	@DisplayName("InsertCompany")
	void insertCompany(){
		IntStream.range(1,10).forEach(i -> {
			CompanyEntity entity = new CompanyEntity();
			entity.setCompanyId("C1234"+i);
			entity.setName("CompanyName"+i);
			entity.setPhone(8934+i);
			entity.setEmail("Company@naver.com"+i);
			companyRepo.save(entity);
		});
	}

	@Test
	@DisplayName("InsertProduct")
	void insertProduct(){
		IntStream.range(1,10).forEach(i -> {
			ProductEntity entity = new ProductEntity();
			entity.setProductId("B1234"+i);
			entity.setThickness(23 * i);
			entity.setWidth(120  * i);
			entity.setLength(58  * i);
			entity.setStock(10 * i);
			productRepo.save(entity);
		});
	}

	@Test
	@DisplayName("FeignClientgetUser")
	void getUser(){
		ResponseUser responseUser = userServiceClient.getUser("sjw782@naver.com");
		Assertions.assertThat(responseUser).isNotNull();
	}
	*/


	@Test
	void getProductPlan() {
		//ResponseProductPlan plan = orderService.getProductPlan("son");
		ResponseProductPlan plan = new ResponseProductPlan();
		List<ResponseCompany> companyList = companyService.getCompanies();
		List<ResponseProduct> productList = productService.getProducts();
		ResponseUser responseUser = userServiceClient.getUser("son");

//		Assertions.assertThat(companyList).isNull();

		plan.setCompanyList(companyList);
		plan.setProductList(productList);
		plan.setResponseUser(responseUser);


		plan.getProductList().forEach(r -> {
			log.info(r.toString());
		});

		plan.getCompanyList().forEach(r -> {
			log.info(r.toString());
		});

		log.info(plan.getResponseUser().toString());

	}

}
