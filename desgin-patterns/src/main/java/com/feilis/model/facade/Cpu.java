package com.feilis.model.facade;

/**
 * @ClassName Cpu
 * @Description TODO cpu类别
 * @Author lf199
 * @Date 2020/10/12 11:33
 * @Version V1.0
 */
public class Cpu implements Operatorable {
    @Override
    public void boot() {
        System.out.println("开启cpu......");
    }

    @Override
    public void shutDown() {
        System.out.println("关闭cpu......");
    }

    @Override
    public void reboot() {
        System.out.println("重启cpu......");
    }
}
