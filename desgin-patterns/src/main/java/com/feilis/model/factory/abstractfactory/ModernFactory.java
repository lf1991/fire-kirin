package com.feilis.model.factory.abstractfactory;

/**
 * 现代工厂(具体工厂  意在生成具体的产品)
 */
public class ModernFactory extends AbstractFactory{

    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Weapon createWeapon() {
        return new AK47();
    }

    @Override
    Vehicle createVehicle() {
        return new Car();
    }
}
