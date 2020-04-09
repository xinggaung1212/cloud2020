package com.atguigu.springcloud;

import com.atguigu.myrule.MyselRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author xy
 * @version 1.0
 * @date 2020/4/5 15:15
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="CLOUD-PAYMENT-SERVICE",configuration = MyselRule.class)
public class orderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(orderMain80.class,args);
    }
}
