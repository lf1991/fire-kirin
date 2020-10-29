package com.feilis.model.mediator;

/**
 * @ClassName Client
 * @Description TODO 调停者模式
 * @Author lf199
 * @Date 2020/10/12 11:33
 * @Version V1.0
 */
public class Client {
    public static void main(String[] args) {
        //创建调停者——主板
        MainMediator mediator = new MainMediator();
        //创建类
        CDDriver cdDriver = new CDDriver(mediator);
        CPU cpu = new CPU(mediator);
        VideoCard videoCard = new VideoCard(mediator);
        SoundCard soundCard = new SoundCard(mediator);

        //让调停者知道所有同事
        mediator.setCdDriver(cdDriver);
        mediator.setCpu(cpu);
        mediator.setSoundCard(soundCard);
        mediator.setVideoCard(videoCard);

        //cdDriver.readCD();
        cpu.executeData("xxxxx,xxxxx");

    }
}
