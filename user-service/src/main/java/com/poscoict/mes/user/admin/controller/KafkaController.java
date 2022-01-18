package com.poscoict.mes.user.admin.controller;

import com.poscoict.mes.user.admin.dto.CompanyDto;
import com.poscoict.mes.user.admin.dto.ProductDto;
import com.poscoict.mes.user.admin.jpa.CompanyEntity;
import com.poscoict.mes.user.admin.jpa.CompanyRepository;
import com.poscoict.mes.user.admin.jpa.ProductEntity;
import com.poscoict.mes.user.admin.jpa.ProductRepository;
import com.poscoict.mes.user.admin.messagequeue.KafkaProducer;
import com.poscoict.mes.user.admin.vo.RequestCompany;
import com.poscoict.mes.user.admin.vo.RequestProduct;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
