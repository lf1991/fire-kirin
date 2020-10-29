package com.feilis.model.facade;

/**
 * @ClassName Memory
 * @Description TODO
 * @Author lf199
 * @Date 2020/10/12 11:36
 * @Version V1.0
 */
public class Memory implements Operatorable {
    @Override
    public void boot() {
        System.out.println("开启存储器......");
    }

    @Override
    public void shutDown() {
        System.out.println("关闭存储器......");
    }

    @Override
    public void reboot() {
        System.out.println("重启存储器......");
    }
}
