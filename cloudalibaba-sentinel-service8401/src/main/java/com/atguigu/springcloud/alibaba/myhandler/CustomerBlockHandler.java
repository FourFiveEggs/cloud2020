package com.atguigu.springcloud.alibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

/**
 * @author wl
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException1(BlockException exception){
        return new CommonResult(4444,"客户自定义处理逻辑--------CustomerBlockHandler-------1");
    }

    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(4444,"客户自定义处理逻辑--------CustomerBlockHandler-------2");
    }
}
