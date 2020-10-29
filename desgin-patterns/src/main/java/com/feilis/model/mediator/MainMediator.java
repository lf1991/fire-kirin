package com.feilis.model.mediator;

public class MainMediator implements Mediatable {

    //光驱类
    private CDDriver cdDriver = null;
    //cpu类
    private CPU cpu = null;
    //显卡类
    private VideoCard videoCard = null;


    //声卡类
    private SoundCard soundCard = null;

    @Override
    public void changed(Computerable c) {
        if (c instanceof CDDriver) opeCDDriverReadData((CDDriver) c);
        else if (c instanceof CPU) opeCPU((CPU) c);

    }

    private void opeCDDriverReadData(CDDriver cdDriver) {
        //光驱中获取数据
        String data = cdDriver.getData();
        //把这些数据传递给CPU进行处理
        cpu.executeData(data);
    }

    private void opeCPU(CPU cpu) {
        //先获取CPU处理后的数据
        String videoData = cpu.getVideoData();
        String soundData = cpu.getSoundData();
        //把这些数据传递给显卡和声卡展示出来
        videoCard.showData(videoData);
        soundCard.soundData(soundData);

    }

    public CDDriver getCdDriver() {
        return cdDriver;
    }

    public void setCdDriver(CDDriver cdDriver) {
        this.cdDriver = cdDriver;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public VideoCard getVideoCard() {
        return videoCard;
    }

    public void setVideoCard(VideoCard videoCard) {
        this.videoCard = videoCard;
    }

    public SoundCard getSoundCard() {
        return soundCard;
    }

    public void setSoundCard(SoundCard soundCard) {
        this.soundCard = soundCard;
    }
}
