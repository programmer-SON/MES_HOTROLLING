package com.poscoict.mes.user.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poscoict.mes.user.admin.dto.ProductDto;
import com.poscoict.mes.user.admin.messagequeue.KafkaProducer;
import com.poscoict.mes.user.admin.vo.RequestProduct;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.Serializable;
import java.util.*;

@SpringBootTest
@Slf4j
public class kafkaTest {

    KafkaProducer kafkaProducer;

    @Autowired
    public kafkaTest(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @Test
    public void testKafka(){
        RequestProduct product = new RequestProduct();
        product.setLength(12.0);
        product.setThickness(150.4);
        product.setWidth(20.5);
        product.setProductId("AB1236");

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        ProductDto productDto = mapper.map(product, ProductDto.class);

 //       kafkaProducer.send("product-topic", productDto);

    }

    @Test
    public void testMapper(){
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "";

        CheckTemp checkTemp = new CheckTemp();

        List<String> list = Arrays.asList(new String("abc"),
                new String("abcdef"),
                new String("gsgkjl"));
        checkTemp.setChecks(list);

        try {
            jsonInString = mapper.writeValueAsString(checkTemp);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        log.info(jsonInString);


        Map<Object, Object> map = new HashMap<>();

        try{
            map = mapper.readValue(jsonInString, new TypeReference<Map<Object, Object>>() {});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        List<String> temp =  (List<String>) map.get("checks");

        log.info(temp.get(0));
    }

}

@Data
class CheckTemp implements Serializable {
    List<String> checks;
}