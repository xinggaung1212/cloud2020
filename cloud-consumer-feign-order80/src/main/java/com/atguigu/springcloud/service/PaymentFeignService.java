package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author xy
 * @version 1.0
 * @date 2020/4/9 13:45
 */
@Component
@FeignClient(value="CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping( value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentByid(@PathVariable("id") Long id);
    @GetMapping(value="/payment/timeout")
    String gettimeout();
}
