package com.feilis.model.factory.simplefactory;

/**
 * 公交交通工具
 */
public class Bus implements Moveable {
    @Override
    public void go() {
        System.out.println("出行使用公交车");
    }
}
