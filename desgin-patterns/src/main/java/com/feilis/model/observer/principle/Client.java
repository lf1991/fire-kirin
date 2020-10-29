package com.feilis.model.observer.principle;

/**
 * @ClassName Client
 * @Description TODO 观察者模式
 * @Author lf199
 * @Date 2020/10/20 11:02
 * @Version V1.0
 */
public class Client {
    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        subject.add(new ConcreteObserver1());
        subject.add(new ConcreteObserver2());
        subject.notifyObserver();
    }
}
