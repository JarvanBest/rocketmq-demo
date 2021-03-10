package com.shuhai.rocketmq.demo.service.impl;

import com.shuhai.rocketmq.demo.model.Order;
import com.shuhai.rocketmq.demo.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class OrderServiceImpl implements IOrderService {
    @Override
    public void save(Order order) {
        System.out.println("============保存订单成功：" + order.getOrderId());
    }
}