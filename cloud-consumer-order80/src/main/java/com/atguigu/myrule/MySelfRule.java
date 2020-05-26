package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Create By wl on 2020/5/11
 * @author wl
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){

        /**
         * 使用随机策略
         */
        return new RandomRule();
    }
}
