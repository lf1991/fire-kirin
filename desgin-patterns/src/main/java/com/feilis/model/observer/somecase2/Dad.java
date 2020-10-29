package com.feilis.model.observer.somecase2;

/**
 * @ClassName Dad
 * @Description TODO
 * @Author lf199
 * @Date 2020/10/20 23:17
 * @Version V1.0
 */
public class Dad implements Observer {
    @Override
    public void actionOnWakeUp(WakeUpEvent e) {
        feed(e);
    }

    public void feed(WakeUpEvent e) {
        System.out.println(e.loc);
        System.out.println("父亲喂孩子......");
    }
}
