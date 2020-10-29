package com.feilis.model.mediator;

/**
 * 电脑cpu类
 */
public class CPU extends Computerable {

    //视频数据
    private String videoData = "";
    //音频数据
    private String soundData = "";

    public CPU(Mediatable mediator) {
        super(mediator);
    }

    public void executeData(String data) {
        String[] array = data.split(",");
        this.videoData = array[0];
        this.soundData = array[1];
        //通知主板，CPU完成工作
        getMediator().changed(this);
    }

    public String getVideoData() {
        return videoData;
    }

    public void setVideoData(String videoData) {
        this.videoData = videoData;
    }

    public String getSoundData() {
        return soundData;
    }

    public void setSoundData(String soundData) {
        this.soundData = soundData;
    }
}
