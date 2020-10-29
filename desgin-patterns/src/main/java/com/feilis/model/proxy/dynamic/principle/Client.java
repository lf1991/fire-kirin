package com.feilis.model.proxy.dynamic.principle;


import java.lang.reflect.Proxy;

/**
 * @ClassName Client
 * @Description TODO 动态代理客户类
 * @Author lf199
 * @Date 2020/10/12 15:31
 * @Version V1.0
 */
public class Client {
    public static void main(String[] args) {
        IPerson realSubject = new Man();
        NormalHandler handler = new NormalHandler<IPerson>(realSubject);
        ClassLoader loader = realSubject.getClass().getClassLoader();
        Class[] interfaces = realSubject.getClass().getInterfaces();
        IPerson proxy = (IPerson) Proxy.newProxyInstance(loader, interfaces, handler);
        System.out.println("动态代理对象的类型：" + proxy.getClass().getName());
        proxy.doWork();
    }
}
