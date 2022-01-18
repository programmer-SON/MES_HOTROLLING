package com.poscoict.mes.process.product.messagequeue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poscoict.mes.process.company.jpa.CompanyEntity;
import com.poscoict.mes.process.company.jpa.CompanyRepository;
import com.poscoict.mes.process.order.jpa.OrderEntity;
import com.poscoict.mes.process.product.jpa.ProductEntity;
import com.poscoict.mes.process.product.jpa.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class KafkaConsumer {
    ProductRepository productRepository;
    CompanyRepository companyRepository;

    @Autowired
    public KafkaConsumer(ProductRepository productRepository,  CompanyRepository companyRepository) {
        this.productRepository = productRepository;
        this.companyRepository = companyRepository;
    }

    @KafkaListener(topics = "product-topic")
    public void createProduct(String kafkaMessage){
        log.info("Kafka Product Message: -> " + kafkaMessage);

        Map<Object, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();

        try{
            map = mapper.readValue(kafkaMessage, new TypeReference<Map<Object, Object>>() {});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        ProductEntity entity = new ProductEntity();
        entity.setLength((Double) map.get("length"));
        entity.setWidth((Double) map.get("width"));
        entity.setThickness((Double) map.get("thickness"));
        entity.setProductId((String)map.get("productId"));
        productRepository.save(entity);
    }

    @KafkaListener(topics = "company-topic")
    public void createCompany(String kafkaMessage){
        log.info("Kafka Company Message: -> " + kafkaMessage);

        Map<Object, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();

        try{
            map = mapper.readValue(kafkaMessage, new TypeReference<Map<Object, Object>>() {});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        CompanyEntity entity = new CompanyEntity();
        entity.setCompanyId((String) map.get("companyId"));
        entity.setName((String) map.get("name"));
        entity.setPhone((Integer) map.get("phone"));
        entity.setEmail((String)map.get("email"));

        companyRepository.save(entity);
    }

    @KafkaListener(topics = "company-delete-topic")
    public void deleteCompany(String kafkaMessage){
        log.info("Kafka Company Delete Message: -> " + kafkaMessage);

        Map<Object, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();

        try{
            map = mapper.readValue(kafkaMessage, new TypeReference<Map<Object, Object>>() {});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        List<String> checks =  (List<String>) map.get("checks");

        for(String companyId : checks){
            Optional<CompanyEntity> oEntity = companyRepository.findByCompanyId(companyId);
            if(oEntity.isPresent()){
                companyRepository.delete(oEntity.get());
            }
        }
    }

    @KafkaListener(topics = "product-delete-topic")
    public void deleteProduct(String kafkaMessage){
        log.info("Kafka Product Delete Message: -> " + kafkaMessage);

        Map<Object, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();

        try{
            map = mapper.readValue(kafkaMessage, new TypeReference<Map<Object, Object>>() {});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        List<String> checks =  (List<String>) map.get("checks");

        for(String productId : checks){
            Optional<ProductEntity> oEntity = productRepository.findByProductId(productId);
            if(oEntity.isPresent()){
                productRepository.delete(oEntity.get());
            }
        }
    }
}
