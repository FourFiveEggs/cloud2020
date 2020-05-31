package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wl
 */
@RestController
public class SendMessageController {


    @Resource
    private IMessageProvider iMessageProvider;


    @GetMapping(value = "/sendMessage")
    private String sendMessage(){
        return iMessageProvider.send();
    }
}
