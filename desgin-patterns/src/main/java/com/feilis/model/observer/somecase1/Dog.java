package com.feilis.model.observer.somecase1;

/**
 * @ClassName Dog
 * @Description TODO
 * @Author lf199
 * @Date 2020/10/20 23:18
 * @Version V1.0
 */
public class Dog implements Observer {
    @Override
    public void actionOnWakeUp() {
        howl();
    }

    public void howl() {
        System.out.println("小狗噢噢噢叫......");
    }
}
