package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author xy
 * @version 1.0
 * @date 2020/4/5 13:18
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String servicePort;
    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping(value="/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        Boolean b= paymentService.save(payment);
        if(b){
            return new CommonResult<Payment>(200,"保存成功,servicePort="+servicePort);
        }else{
            return new CommonResult<Payment>(400,"保存失败,servicePort="+servicePort);
        }
    }

    @GetMapping( value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentByid(@PathVariable("id") Long id){
        Payment payment=paymentService.getById(id);
        if(payment!=null){
            return new CommonResult<Payment>(200,"查询成功,servicePort="+servicePort,payment);
        }else{
            return new CommonResult<Payment>(400,"查询失败,servicePort="+servicePort,null);
        }
    }
    @GetMapping(value="/payment/discovery")
    public Object getdiscovery(){
        List<String> services=discoveryClient.getServices();
        for(String service:services){
            log.info("*****service=="+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance instance:instances){
            log.info(""+instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri() );
        }
        return discoveryClient;
    }
    @GetMapping(value="/payment/lib")
    public String getport(){
        return servicePort;
    }

    @GetMapping(value="/payment/timeout")
    public String gettimeout() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return servicePort;
    }
}
