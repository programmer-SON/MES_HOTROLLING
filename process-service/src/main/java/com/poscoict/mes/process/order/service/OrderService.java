package com.poscoict.mes.process.order.service;

import com.poscoict.mes.process.order.vo.RequestOrder;
import com.poscoict.mes.process.order.vo.ResponseProductPlan;
import org.springframework.stereotype.Service;

import java.text.ParseException;

//@Service
public interface OrderService {

    public void createOrder(RequestOrder requestOrder) throws ParseException;

    public ResponseProductPlan getProductPlan(String userId);
}
