package com.feilis.model.facade;

/**
 * @ClassName Client
 * @Description TODO 门面模式
 * @Author lf199
 * @Date 2020/10/12 11:05
 * @Version V1.0
 */
public class Client {
    public static void main(String[] args) {
        ComputerFacade facade = new ComputerFacade();
        //开机
        facade.boot();
        //关闭
        facade.shutDown();
        //重启
        facade.reboot();
    }
}
