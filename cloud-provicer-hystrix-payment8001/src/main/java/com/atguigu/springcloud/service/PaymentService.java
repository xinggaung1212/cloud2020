package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.entities.Payment;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author xy
 * @version 1.0
 * @date 2020/4/5 13:14
 */
public interface PaymentService extends IService<Payment> {
    public String paymentinfo_ok(Integer id);
    public String paymentinfo_timeout(Integer id);
    public String paymentCircuitBreaker(Integer id);
    public String paymentCircuitBreaker_fallback(Integer id);
}
