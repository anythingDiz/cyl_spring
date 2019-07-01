package com.cyl.demo.aop.advice;

import java.time.Instant;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/7/1
 */
public class MethodPerformance {
    private String serviceMethod;
    private Long start;
    private Long end;

    public MethodPerformance(String serviceMethod) {
        this.serviceMethod = serviceMethod;
        this.start = Instant.now().toEpochMilli();
    }

    public void printPerformance(){
        this.end = Instant.now().toEpochMilli();

        long elapse = end - start;
        System.out.println(">> "+serviceMethod +" 花费 "+ elapse +" 毫秒");
    }



    public String getServiceMethod() {
        return serviceMethod;
    }

    public void setServiceMethod(String serviceMethod) {
        this.serviceMethod = serviceMethod;
    }
}
