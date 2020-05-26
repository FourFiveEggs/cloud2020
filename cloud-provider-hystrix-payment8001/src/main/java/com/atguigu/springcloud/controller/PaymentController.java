package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Create By wl on 2020/5/14
 * @author wl
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String servicePort;


    /**
     * 正常访问
     * @param id
     * @return
     */
    @RequestMapping(value = "/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_OK(id);
        //日志
        log.info("*******result : " + result);
        return result;
    }

    @RequestMapping(value = "/payment/hystrix/timeout/{id}")

    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_TimeOut(id);
        //日志
        log.info("++++++result : " + result);
        return result;
    }

    /**
     * 服务熔断
     * @param id 输入的参数id
     * @return 返回的信息
     */
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymnetCircuitBreaker(id);
        //日志
        log.info("********服务熔断-result : " + result);
        return result;

    }
}
