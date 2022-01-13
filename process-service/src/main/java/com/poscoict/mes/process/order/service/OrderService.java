package com.poscoict.mes.process.order.service;

import com.poscoict.mes.process.order.vo.ResponseProductPlan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    public List<ResponseProductPlan> getProductPlan();
}
