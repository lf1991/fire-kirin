package com.feilis.model.observer.principle;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Subject
 * @Description TODO 观察者模式抽象主题
 * @Author lf199
 * @Date 2020/10/20 11:02
 * @Version V1.0
 */
public abstract class Subject {

    //观察者容器
    protected List<Observer> observers = new ArrayList<Observer>();


    public abstract void notifyObserver(); //通知观察者方法

    /**
     * 功能描述: <br>
     * 〈添加观察者〉
     *
     * @Param: [o]
     * @Return: void
     * @Author: lf199
     * @Date: 2020/10/20 11:07
     */
    public void add(Observer o) {
        if (o == null) throw new NullPointerException();
        this.observers.add(o);
    }

    /**
     * 功能描述: <br>
     * 〈清除观察者〉
     *
     * @Param: [o]
     * @Return: void
     * @Author: lf199
     * @Date: 2020/10/20 11:07
     */
    public void remove(Observer o) {
        if (o == null) throw new NullPointerException();
        this.observers.remove(o);
    }

    /**
     * 功能描述: <br>
     * 〈参数校验〉
     *
     * @Param: [o]
     * @Return: boolean
     * @Author: lf199
     * @Date: 2020/10/20 11:07
     */
    public boolean check(Observer o) {
        if (o == null) return false;
        else return true;
    }
}
