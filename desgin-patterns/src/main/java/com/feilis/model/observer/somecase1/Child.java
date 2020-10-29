package com.feilis.model.observer.somecase1;




import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Child
 * @Description TODO
 * @Author lf199
 * @Date 2020/10/20 23:14
 * @Version V1.0
 */
public class Child {
    private List<Observer> obersers = new ArrayList<Observer>();

    public void wakeUp() {
        for (Observer observer : obersers) {
            observer.actionOnWakeUp();
        }
    }

    public void add(Observer o) {
        if (null == o) throw new NullPointerException();
        obersers.add(o);
    }

    public int remove(Observer o) {
        if (null == o) return -1;
        obersers.remove(o);
        return 1;
    }
}
