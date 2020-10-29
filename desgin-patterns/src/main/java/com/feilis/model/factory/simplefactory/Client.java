package com.feilis.model.factory.simplefactory;

/**
 * 客户端类
 */
public class Client {
    public static void main(String[] args) {
        Moveable m = new VehicleFactory().createBus();
        m.go();
        m=new VehicleFactory().createPlan();
        m.go();
    }
}
