package com.feilis.model.observer.somecase1;

/**
 * @ClassName Dad
 * @Description TODO
 * @Author lf199
 * @Date 2020/10/20 23:17
 * @Version V1.0
 */
public class Mum implements Observer {
    @Override
    public void actionOnWakeUp() {
        hung();
    }

    public void hung() {
        System.out.println("母亲抱孩子......");
    }
}
