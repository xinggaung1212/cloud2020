package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author xy
 * @version 1.0
 * @date 2020/4/9 17:13
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystritDashboard9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystritDashboard9001.class,args);
    }
}
