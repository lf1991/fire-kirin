package com.feilis.model.singleton;

/**
 * @ClassName HungrySingleton
 * @Description 单例模式之饿汉模式：先加载类在使用,线程绝对安全，多线程可以直接使用
 * @Author lf199
 * @Date 2020/9/25 11:17
 * @Version V1.0
 */
public class HungrySingleton {

    private static final HungrySingleton singleton = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        //现成沉睡10毫秒 测试
        try {
            Thread.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return singleton;
    }

    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            new Thread(()->{
                System.out.println(HungrySingleton.getInstance().hashCode());
            }).start();
        }
    }
}
