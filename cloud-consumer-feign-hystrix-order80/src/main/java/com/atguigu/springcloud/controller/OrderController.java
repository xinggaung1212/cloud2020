package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xy
 * @version 1.0
 * @date 2020/4/5 15:54
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "globlepaymentinfo_timeouthandler")
public class OrderController {
    // public static final String PAYMENT_URL="http://localhost:8001";

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping(value="/consumer/payment/hystrix/ok/{id}")

    public String paymentinfo_ok(@PathVariable("id") Integer id){
        return paymentFeignService.paymentinfo_ok(id);
    }

    @GetMapping(value="/consumer/payment/hystrix/timeout/{id}")
    /*@HystrixCommand(fallbackMethod = "paymentinfo_timeouthandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })*/
    @HystrixCommand
    public String paymentinfo_timeout(@PathVariable("id") Integer id){
        int age=10/0;
        return paymentFeignService.paymentinfo_timeout(id);
    }
    public String paymentinfo_timeouthandler(Integer id) {

        return "线程池"+Thread.currentThread().getName()+"服务器繁忙或出错！";
    }
    public String globlepaymentinfo_timeouthandler() {

        return "线程池"+Thread.currentThread().getName()+",全局服务器繁忙或出错！";
    }
}
