package com.feilis.model.observer.principle;

/**
 * @ClassName ConcreteSubject
 * @Description TODO
 * @Author lf199
 * @Date 2020/10/20 11:08
 * @Version V1.0
 */
public class ConcreteSubject extends Subject {

    @Override
    public void notifyObserver() {
        System.out.println("具体目标发生改变...");
        System.out.println("--------------");

        for (Observer o : observers) {
            o.response();
        }
    }
}
