package com.feilis.model.factory.abstractfactory;

/**
 * 魔法工厂(具体工厂  意在生成具体的产品)
 */
public class MagicFactory extends AbstractFactory {

    @Override
    Food createFood() {
        return new MushRoom();
    }

    @Override
    Weapon createWeapon() {
        return new MagicStick();
    }

    @Override
    Vehicle createVehicle() {
        return new Broom();
    }
}
