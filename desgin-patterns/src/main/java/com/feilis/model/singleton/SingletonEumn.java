package com.feilis.model.singleton;

/**
 * @ClassName SingletonEumn
 * @Description TODO
 * @Author lf199
 * @Date 2020/9/29 11:46
 * @Version V1.0
 */
public enum  SingletonEumn {

    INSTANCE;

    public static  SingletonEumn getInstance(){
        return INSTANCE;
    }


    public void doWork(){
        System.out.println("work");
    }

    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            new Thread(()->{
                SingletonEumn instance=SingletonEumn.getInstance();
                instance.doWork();
                System.out.println(instance.hashCode());
            }).start();
        }
    }
}
