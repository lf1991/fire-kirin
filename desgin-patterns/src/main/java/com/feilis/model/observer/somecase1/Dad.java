package com.feilis.model.observer.somecase1;

/**
 * @ClassName Dad
 * @Description TODO
 * @Author lf199
 * @Date 2020/10/20 23:17
 * @Version V1.0
 */
public class Dad implements Observer {
    @Override
    public void actionOnWakeUp() {
        feed();
    }

    public void feed() {
        System.out.println("父亲喂孩子......");
    }
}
