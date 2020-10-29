package com.feilis.model.mediator;

/**
 * 显卡类
 */
public class VideoCard extends Computerable{
    public VideoCard(Mediatable mediator) {
        super(mediator);
    }

    /**
     * 显示视频数据
     */
    public void showData(String data){
        System.out.println("您正在观看的是：" + data);
    }

}
