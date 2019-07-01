package com.cyl.demo.aop.advice;

import com.cyl.demo.aop.advice.MethodPerformance;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/7/1
 */
public class PerformanceMonitor {
    private static ThreadLocal<MethodPerformance> performanceRecord = new ThreadLocal<>();

    public static void start(String method){
        System.out.println(">> start monitor");
        MethodPerformance mp = new MethodPerformance(method);

        performanceRecord.set(mp);
    }

    public static void end(){
        System.out.println(">> end monitor");
        MethodPerformance mp = performanceRecord.get();

        //打印方法性能监控的结果信息
        if(mp == null){
            System.out.println(">> 使用错误");
        }else{
            mp.printPerformance();
        }
    }
}
