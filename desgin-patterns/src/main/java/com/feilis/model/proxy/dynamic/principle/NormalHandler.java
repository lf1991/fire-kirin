package com.feilis.model.proxy.dynamic.principle;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName NormalHandler
 * @Description TODO
 * @Author lf199
 * @Date 2020/10/12 15:31
 * @Version V1.0
 */
public class NormalHandler<T> implements InvocationHandler {

    private T target;


    public NormalHandler(T target) {
        this.target = target;
    }

    public void preWork() {
        System.out.println("前戏......");
    }

    public void postWork() {
        System.out.println("收场......");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        preWork();

        if (null != args)
            for (Object o : args) {
                System.out.println("arg: " + o);
            }
        Object invoke = method.invoke(target, args);
        postWork();
        return invoke;
    }
}
