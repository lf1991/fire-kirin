package com.feilis.model.factory.simplefactory;

/**
 * 汽车交通工具
 */
public class Car implements Moveable {

    @Override
    public void go() {
        System.out.println("出行使用汽车");
    }
}
