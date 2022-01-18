package com.poscoict.mes.user.kafka;

import com.poscoict.mes.user.admin.dto.ProductDto;
import com.poscoict.mes.user.admin.messagequeue.KafkaProducer;
import com.poscoict.mes.user.admin.vo.RequestProduct;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
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
}
