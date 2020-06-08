package com.atguigu.springcloud.alibaba.dao;

import com.atguigu.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Create By wl on 2020/6/8
 * @author wl
 */
@Mapper
public interface OrderDao {

    /**
     * 新建订单
     * @param order
     */
    void create(Order order);

    /**
     * 修改订单状态，从零修改为1
     * @param userId
     * @param status
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
