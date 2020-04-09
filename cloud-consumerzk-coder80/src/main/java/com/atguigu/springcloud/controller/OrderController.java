package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author xy
 * @version 1.0
 * @date 2020/4/5 15:54
 */
@RestController
@Slf4j
public class OrderController {
    // public static final String PAYMENT_URL="http://localhost:8001";
    public static final String PAYMENT_URL="http://cloud-payment-service";
    @Autowired
    private  RestTemplate restTemplate;
    @GetMapping("/consumer/payment/zk/create")
    public CommonResult<Payment> create(Payment payment){
        log.info("payment===="+payment);
        return  restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }
    @GetMapping("/consumer/payment/zkget/{id}")
    public CommonResult<Payment> getpayment(@PathVariable("id") Long id){
        log.info("==="+id);
        return  restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
}
