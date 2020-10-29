package com.feilis.model.factory.simplefactory;

/**
 * 飞机交通工具
 */
public class Plane implements Moveable {
    @Override
    public void go() {
        System.out.println("出行使用飞机");
    }
}
