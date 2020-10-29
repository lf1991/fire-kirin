package com.feilis.model.observer.somecase1;

/**
 * @ClassName Client
 * @Description TODO
 * @Author lf199
 * @Date 2020/10/20 23:13
 * @Version V1.0
 */
public class Client {
    public static void main(String[] args) {
        Child child = new Child();
        child.add(new Dad());
        child.add(new Mum());
        child.add(new Dog());
        child.wakeUp();
    }
}
