package com.feilis.model.factory.abstractfactory;

/**
 * 汽车交通工具
 */
public class Car extends Vehicle {
    @Override
    void go() {
        System.out.println("汽车启动.....");
    }
}
