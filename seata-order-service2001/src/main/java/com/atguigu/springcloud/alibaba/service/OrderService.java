package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.alibaba.domain.Order;

/**
 * Create By wl on 2020/6/8
 * @author wl
 */
public interface OrderService {

    /**
     * 创建订单
     * @param order 订单实体
     */
    void create(Order order);
}
