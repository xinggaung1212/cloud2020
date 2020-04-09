package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author xy
 * @version 1.0
 * @date 2020/4/9 16:10
 */
@Component
public class Paymentfallbackservice implements  PaymentFeignService {
    @Override
    public String paymentinfo_ok(Integer id) {
        return "--falback-----ok";
    }

    @Override
    public String paymentinfo_timeout(Integer id) {
        return "--falback-----timeout";
    }
}
