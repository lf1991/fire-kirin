package com.feilis.model.facade;

/**
 * @ClassName ComputerFacade
 * @Description TODO 计算机门面类
 * @Author lf199
 * @Date 2020/10/12 11:38
 * @Version V1.0
 */
public class ComputerFacade {
    private static Cpu cpu;
    private static Memory memory;
    private static Disk disk;

    static {
        cpu = new Cpu();
        memory = new Memory();
        disk = new Disk();
    }

    /**
     * 功能描述: <br> 计算机开启
     * 〈〉
     *
     * @Param: []
     * @Return: void
     * @Author: lf199
     * @Date: 2020/10/12 11:41
     */
    void boot() {
        cpu.boot();
        memory.boot();
        disk.boot();
    }

    /**
     * 功能描述: <br> 计算机关闭
     * 〈〉
     *
     * @Param: []
     * @Return: void
     * @Author: lf199
     * @Date: 2020/10/12 11:41
     */
    void shutDown() {
        cpu.shutDown();
        memory.shutDown();
        disk.shutDown();
    }

    /**
     * 功能描述: <br> 计算机重启
     * 〈〉
     *
     * @Param: []
     * @Return: void
     * @Author: lf199
     * @Date: 2020/10/12 11:41
     */
    void reboot() {
        cpu.reboot();
        memory.reboot();
        disk.reboot();
    }
}
