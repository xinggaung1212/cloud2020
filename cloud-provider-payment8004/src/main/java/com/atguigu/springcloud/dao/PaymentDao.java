package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xy
 * @version 1.0
 * @date 2020/4/5 13:01
 */
@Mapper
public interface PaymentDao extends BaseMapper<Payment> {
}
