package com.feilis.model.mediator;

/**
 * 声卡类
 */
public class SoundCard extends Computerable {

    public SoundCard(Mediatable mediator) {
        super(mediator);
    }


    /**
     * 按照声频数据发出声音
     */
    public void soundData(String data) {
        System.out.println("画外音：" + data);
    }
}
