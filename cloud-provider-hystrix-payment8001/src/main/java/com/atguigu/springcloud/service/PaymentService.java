package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * Create By wl on 2020/5/12
 *
 * @author wl
 */
@Service
@Slf4j
public class PaymentService {

    /**
     * 正常访问
     * @param id id
     * @return 出错信息
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池" + Thread.currentThread() + "paymentOK,id : " + id + "\t" + "😄 哈哈 ~";
    }

    /**
     * 超时访问
     * @param id 传入的ID
     * @return 放回的提示信息
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            //设置这个线程池的超时时间是3s,3s内是正常的业务逻辑，超过3s调用fallbackMethod指定的方法进行处理
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber = 5;
        try {
//            int age = 10/0;
            //暂停5秒钟
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (Exception e) {
            log.error("TimeOut出错了，快来看看！" + e);
        }

        return "线程池" + Thread.currentThread() + "paymentOK,id : " + id + "\t" + "😩  呜呜~ ； 耗时（秒） ："
                + timeNumber;
    }

    public String paymentInfo_TimeOutHandler(Integer id){
//        return "线程池 ：" + Thread.currentThread().getName()
//                + "...8001系统繁忙或者系统报错，请稍后再试试，id:.. " + id + "\t" +"😭";
        return "调用支付接口超时或异常 ： \t" + "\t当前线程池的名称是：" + Thread.currentThread().getName();
    }


    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") //失败率达到多少后跳闸
    })
    public String paymnetCircuitBreaker(@PathVariable("id") Integer id){

        if(id < 0){
            throw new RuntimeException("#########id不能为负数######");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t" + "调用成功，流水号 ： " + serialNumber;
    }


    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能是负数，请稍后再试，😄  ID : " + id;
    }
}
