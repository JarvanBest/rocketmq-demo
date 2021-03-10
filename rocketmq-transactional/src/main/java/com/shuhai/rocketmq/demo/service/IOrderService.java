package com.shuhai.rocketmq.demo.service;


import com.shuhai.rocketmq.demo.model.Order;


public interface IOrderService {
    void save(Order order);
}
