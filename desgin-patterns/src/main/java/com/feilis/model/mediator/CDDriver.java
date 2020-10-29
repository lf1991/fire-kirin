package com.feilis.model.mediator;

/**
 * 光驱类
 */
public class CDDriver extends Computerable {


    public String data = "";

    public CDDriver(Mediatable mediator) {
        super(mediator);
    }

    public void readCD() {
        this.data = "读取光驱视频数据,读取光驱音频数据";
        this.getMediator().changed(this);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
