package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Create By wl on 2020/4/15
 * @author wl
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * applicationContext <bean id="" classs=""></bean>
     * @loadbalanced 负载均衡
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){

        return new RestTemplate();
    }
}
