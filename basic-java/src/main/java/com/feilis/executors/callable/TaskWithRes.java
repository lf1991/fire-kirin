package com.feilis.executors.callable;

import java.util.concurrent.Callable;

/**
 * @ClassName TaskWithRes
 * @Description TODO
 * @Author lf199
 * @Date 2021/6/23 17:16
 * @Version V1.0
 */
public class TaskWithRes implements Callable<String> {
    private int id;

    public TaskWithRes(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        System.out.println("call()方法被自动调用！！！    " + Thread.currentThread().getName());
        return "call()方法被自动调用，任务返回的结果是：" + id + "    " + Thread.currentThread().getName();
    }
}
