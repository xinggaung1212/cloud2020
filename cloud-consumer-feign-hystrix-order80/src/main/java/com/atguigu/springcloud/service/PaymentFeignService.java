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
@FeignClient(value="CLOUD-PAYMENT-HYSTRIX-PROVIDER",fallback = Paymentfallbackservice.class)
public interface PaymentFeignService {
    @GetMapping(value="/payment/hystrix/ok/{id}")
    public String paymentinfo_ok(@PathVariable("id") Integer id);
    @GetMapping(value="/payment/hystrix/timeout/{id}")
    public String paymentinfo_timeout(@PathVariable("id") Integer id);
}
