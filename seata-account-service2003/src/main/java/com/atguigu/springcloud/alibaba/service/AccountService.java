package com.atguigu.springcloud.alibaba.service;

import java.math.BigDecimal;

/**
 * @author wl
 */
public interface AccountService {

    void decrease(Long userId, BigDecimal money);
}
