package com.poscoict.mes.process.order.jpa;

import java.util.Date;
import java.util.stream.IntStream;

import com.poscoict.mes.process.company.jpa.CompanyEntity;
import com.poscoict.mes.process.company.jpa.CompanyRepository;
import com.poscoict.mes.process.product.jpa.ProductEntity;
import com.poscoict.mes.process.product.jpa.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
//@RunWith(SpringRunner.class)
class OrderTest {

	OrderRepository orderRepo;
	CompanyRepository companyRepo;
	ProductRepository productRepo;

	@Autowired
	public OrderTest(OrderRepository orderRepo, CompanyRepository companyRepo, ProductRepository productRepo) {
		this.orderRepo = orderRepo;
		this.companyRepo = companyRepo;
		this.productRepo = productRepo;
	}


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
			orderRepo.save(entity);
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
	void getOrders() {}

}
