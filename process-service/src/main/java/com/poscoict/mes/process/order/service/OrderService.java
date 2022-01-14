package com.poscoict.mes.process.order.service;

import com.poscoict.mes.process.order.vo.RequestOrder;
import com.poscoict.mes.process.order.vo.ResponseProductPlan;
import org.springframework.stereotype.Service;

//@Service
public interface OrderService {

    public void createOrder(RequestOrder requestOrder);

    public ResponseProductPlan getProductPlan(String userId);
}
