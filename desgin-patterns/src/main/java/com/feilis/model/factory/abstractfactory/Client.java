package com.feilis.model.factory.abstractfactory;

/**
 * 客户类
 */
public class Client {
    public static void main(String[] args) {
        //现代工厂
        ModernFactory modernFactory = new ModernFactory();
        Vehicle v = modernFactory.createVehicle();
        v.go();
        Weapon w = modernFactory.createWeapon();
        w.shoot();
        Food f = modernFactory.createFood();
        f.printName();

        //魔法工厂
        MagicFactory magicFactory = new MagicFactory();

        Vehicle vm = magicFactory.createVehicle();
        vm.go();
        Weapon wm = magicFactory.createWeapon();
        wm.shoot();
        Food fm = magicFactory.createFood();
        fm.printName();
    }
}
