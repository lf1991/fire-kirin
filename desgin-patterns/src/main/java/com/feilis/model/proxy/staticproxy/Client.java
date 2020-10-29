package com.feilis.model.proxy.staticproxy;

/**
 * @ClassName Client
 * @Description TODO  静态代理案例
 * @Author lf199
 * @Date 2020/10/20 9:50
 * @Version V1.0
 */
public class Client {

    public static void main(String[] args) {
        MineProxy proxy = new MineProxy();
        proxy.setRealSubject(new RealSubject());
        proxy.request();
    }
}
