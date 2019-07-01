package com.cyl.demo.aop.service;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/7/1
 */
public class CylServiceImpl implements CylService {
    @Override
    public void add() throws InterruptedException {
        System.out.println(">> 模拟增加操作");
        TimeUnit.MILLISECONDS.sleep(1000);
    }

    @Override
    public void remove() throws InterruptedException {
        System.out.println(">> 模拟移除操作");
        TimeUnit.MILLISECONDS.sleep(5000);
    }
}
