package com.feilis.model.factory.simplefactory;

/**
 * 简单的交通工具生产工厂类...简单工厂类
 * 可扩展性 不好
 */
public class VehicleFactory {

    public Car createCar() {
        //前置操作 略
        return new Car();
    }

    public Bus createBus() {
        //前置操作 略
        return new Bus();
    }

    public Plane createPlan() {
        //前置操作 略
        return new Plane();
    }
}
