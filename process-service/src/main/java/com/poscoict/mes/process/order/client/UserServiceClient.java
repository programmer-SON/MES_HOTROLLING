package com.poscoict.mes.process.order.client;

import com.poscoict.mes.process.order.vo.ResponseUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
public interface UserServiceClient {

    @GetMapping("/users/{userId}")
    ResponseUser getUser(@PathVariable String userId);
}
