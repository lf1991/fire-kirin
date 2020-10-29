package com.feilis.model.observer.somecase2;

/**
 * @ClassName WakeUpEvent
 * @Description TODO
 * @Author lf199
 * @Date 2020/10/20 23:27
 * @Version V1.0
 */
public class WakeUpEvent {

    long timestamp;
    String loc;

    public WakeUpEvent(long timestamp, String loc) {
        this.timestamp = timestamp;
        this.loc = loc;
    }
}
