package com.feilis.model.facade;

/**
 * @ClassName Disk
 * @Description TODO
 * @Author lf199
 * @Date 2020/10/12 11:37
 * @Version V1.0
 */
public class Disk implements Operatorable {
    @Override
    public void boot() {
        System.out.println("开启磁盘......");
    }

    @Override
    public void shutDown() {
        System.out.println("关闭磁盘......");
    }

    @Override
    public void reboot() {
        System.out.println("重启磁盘......");
    }
}
