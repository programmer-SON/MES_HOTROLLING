package com.poscoict.mes.user.admin.controller;

import com.poscoict.mes.user.admin.dto.CompanyCheckDto;
import com.poscoict.mes.user.admin.dto.CompanyDto;
import com.poscoict.mes.user.admin.dto.ProductCheckDto;
import com.poscoict.mes.user.admin.dto.ProductDto;
import com.poscoict.mes.user.admin.jpa.CompanyEntity;
import com.poscoict.mes.user.admin.jpa.CompanyRepository;
import com.poscoict.mes.user.admin.jpa.ProductEntity;
import com.poscoict.mes.user.admin.jpa.ProductRepository;
import com.poscoict.mes.user.admin.messagequeue.KafkaProducer;
import com.poscoict.mes.user.admin.vo.RequestChecks;
import com.poscoict.mes.user.admin.vo.RequestCompany;
import com.poscoict.mes.user.admin.vo.RequestProduct;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class KafkaController {

    KafkaProducer kafkaProducer;

    ProductRepository productRepository;
    CompanyRepository companyRepository;

    @Autowired
    public KafkaController(KafkaProducer kafkaProducer,
                           ProductRepository productRepository,
                           CompanyRepository companyRepository) {
        this.kafkaProducer = kafkaProducer;
        this.productRepository = productRepository;
        this.companyRepository = companyRepository;
    }

    @PostMapping("/products")
    public ResponseEntity<Integer> createProduct( @RequestBody RequestProduct productDetails){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        ProductDto productDto = mapper.map(productDetails, ProductDto.class);

        // user-service -> kafka -> process-service
        kafkaProducer.send("product-topic", productDto);
        ProductEntity entity = mapper.map(productDto, ProductEntity.class);
        productRepository.save(entity);

        return ResponseEntity.status(HttpStatus.CREATED).body(201);
    }

    @PostMapping("/companies")
    public ResponseEntity<Integer> createCompany( @RequestBody RequestCompany companyDetails){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        CompanyDto companyDto = mapper.map(companyDetails, CompanyDto.class);

        // user-service -> kafka -> process-service
        kafkaProducer.send("company-topic", companyDto);
        CompanyEntity entity = mapper.map(companyDto, CompanyEntity.class);
        companyRepository.save(entity);

        return ResponseEntity.status(HttpStatus.CREATED).body(201);
    }

    @PostMapping("/checks/products")
    public ResponseEntity<Integer> deleteProduct(@RequestBody RequestChecks products){

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        ProductCheckDto productCheckDto = mapper.map(products, ProductCheckDto.class);

        List<String> checks = products.getChecks();

        kafkaProducer.send("product-delete-topic", productCheckDto);

        for(String productId : checks){
            Optional<ProductEntity> oEntity = productRepository.findByProductId(productId);
            if(oEntity.isPresent()){
                productRepository.delete(oEntity.get());
            }
        }

        return ResponseEntity.status(HttpStatus.OK).body(200);
    }

    @PostMapping("/checks/companies")
    public ResponseEntity<Integer> deleteCompany(@RequestBody RequestChecks companies){

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        CompanyCheckDto companyCheckDto = mapper.map(companies, CompanyCheckDto.class);

        List<String> checks = companies.getChecks();

        kafkaProducer.send("company-delete-topic", companyCheckDto);

        for(String companyId : checks){
            Optional<CompanyEntity> oEntity = companyRepository.findByCompanyId(companyId);
            if(oEntity.isPresent()){
                companyRepository.delete(oEntity.get());
            }
        }

        return ResponseEntity.status(HttpStatus.OK).body(200);
    }

}
