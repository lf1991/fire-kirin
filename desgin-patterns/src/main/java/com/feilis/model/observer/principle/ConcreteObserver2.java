package com.feilis.model.observer.principle;

/**
 * @ClassName ConcreteObserver1
 * @Description TODO
 * @Author lf199
 * @Date 2020/10/20 11:11
 * @Version V1.0
 */
public class ConcreteObserver2 implements Observer {
    @Override
    public void response() {
        System.out.println("我是一个观察者ConcreteObserver2,我要发生改变......");
    }
}
