package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xy
 * @version 1.0
 * @date 2020/4/8 17:49
 */
@Component
public class MyLB implements LoadBalancer {
    private AtomicInteger atomicInteger=new AtomicInteger(0);
    public final int getandincrement(){
        int current;
        int next;
        do{
            current=this.atomicInteger.get();
            next=current>= Integer.MAX_VALUE?0:current+1;

        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("next888---"+next);
        return next;
    }
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index =getandincrement()%serviceInstances.size();
        return serviceInstances.get(index);
    }
}
