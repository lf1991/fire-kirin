package com.feilis.model.factory.abstractfactory;

/**
 * 抽象工厂类+抽象产品
 */
public abstract class AbstractFactory {
    //生产抽象食品
    abstract Food createFood();

    //生产抽象武器
    abstract Weapon createWeapon();

    //生产抽象交通工具
    abstract Vehicle createVehicle();
}
