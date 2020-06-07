package com.atguigu.springcloud.alibaba.controller;

import ch.qos.logback.core.util.TimeUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

//        try {
//            TimeUnit.SECONDS.sleep( 1 );
//        }catch(Exception e){
//            log.error("-----sleep出错 ：" + e);
//        }
//        //日志
//        log.info("----testD 测试 RT-----");

        //日志
        log.info("----testD 测试异常比例------");
        int age = 10/0;

        return "$$$$$$$ testD $$$$$$$$";
    }

    @GetMapping(value = "/testE")
    public String testE(){
        log.info("------testE 测试异常数*****");
        int age = 10/0;
        return "^^^^^^^^ testE ^^^^^^^^";
    }

    @GetMapping(value = "/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2){
//        int age = 10/0;
        return "-------testHotKey--------";
    }

    public String deal_testHotKey(String p1, String p2, BlockException exception){

        //sentinel 系统默认的提示： Blocked by Sentinel (flow limiting)
        return "----------deal_testHotKey 😭------------";
    }
}
