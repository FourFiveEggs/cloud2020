package com.atguigu.springcloud.alibaba.controller;

import ch.qos.logback.core.util.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * Create By wl on 2020/6/2
 * @author wl
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping(value = "/testA")
    private String testA(){
        return "------testA-----";
    }

    @GetMapping(value = "/testB")
    private String testB(){
        return "******testB*******";
    }

    @GetMapping(value = "/testD")
    private String testD(){

        try {
            TimeUnit.SECONDS.sleep( 1 );
        }catch(Exception e){
            log.error("-----sleep出错 ：" + e);
        }

        /*
         * 日志
         */
        log.info("----testD 测试 RT-----");

        return "$$$$$$$ testD $$$$$$$$";
    }
}
