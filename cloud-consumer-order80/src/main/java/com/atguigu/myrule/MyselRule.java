package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xy
 * @version 1.0
 * @date 2020/4/8 16:26
 */
@Configuration
public class MyselRule {
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}