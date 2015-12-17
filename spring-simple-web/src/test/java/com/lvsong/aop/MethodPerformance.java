package com.lvsong.aop;

/**
 * Created by lvsong on 9/9/15.
 */
public class MethodPerformance {
    private long begin;
    private long end;
    private String methodName;

    public MethodPerformance(String serviceMethod){
        this.methodName = serviceMethod;
        this.begin = System.currentTimeMillis();
    }

    public void printPerformance() {
        this.end = System.currentTimeMillis();

        long elapse = this.end - this.begin;

        System.out.println(this.methodName + "执行花费" + elapse + "毫秒");
    }
}
