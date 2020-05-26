package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * Create By wl on 2020/5/18
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{

    @Override
    public String paymentInfo_ok(Integer id) {
        return "-------PaymentFallbackService fall back-paymentInfo_ok,😭";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "##########PaymentFallbackService fall back-paymentInfo_TimeOut, 😭";
    }
}
