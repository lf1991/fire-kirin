package com.feilis.model.chain.principle;

/**
 * @ClassName Client
 * @Description TODO 责任链模式
 * @Author lf199
 * @Date 2020/10/15 11:57
 * @Version V1.0
 */
public class Client {
    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        handler1.setNext(handler2);
        handler1.handler("one");
    }
}

