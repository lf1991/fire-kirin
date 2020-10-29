package com.feilis.model.chain.somecase2;

/**
 * @ClassName Client
 * @Description TODO 责任链模式案例 改装责任链--链式调用
 * @Author lf199
 * @Date 2020/10/20 9:08
 * @Version V1.0
 */
public class Client {
    public static void main(String[] args) {
        Handler handler1 = new Handler1();
        Handler handler2 = new Handler2();
        Handler handler3 = new Handler3();

        handler1.setNext(handler2);
        handler2.setNext(handler3);
        handler1.handle();
    }
}
