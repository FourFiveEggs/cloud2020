package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Create By wl on 2020/5/15
 * @author wl
 */
@Component
@FeignClient(value = "cloud-provider-hystrix-payment",fallback = PaymentFallbackService.class)
public interface PaymentHystrixService {

    /**
     * 正常访问
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/hystrix/ok/{id}")
    String paymentInfo_ok(@PathVariable("id") Integer id);

    /**
     * 超时访问
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    String paymentInfo_TimeOut(@PathVariable("id") Integer id);
}
