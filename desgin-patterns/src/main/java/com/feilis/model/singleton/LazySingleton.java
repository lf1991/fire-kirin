package com.feilis.model.singleton;

/**
 * @ClassName LazySingleton
 * @Description 单例模式之懒汉模式：按需加载
 * @Author lf199
 * @Date 2020/9/25 10:53
 * @Version V1.0
 */
public class LazySingleton {
    private static volatile LazySingleton singleton = null;

    private LazySingleton() {
    }

    //线程锁
    public static synchronized LazySingleton getInstance() {
        if (singleton == null) {
            singleton = new LazySingleton();
        }
        return singleton;
    }


    //双重锁机制
    public static  LazySingleton getInstance1() {


        if (singleton == null) {

            synchronized(LazySingleton.class){
                if (singleton == null) {
                    singleton = new LazySingleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            new Thread(()->{
                System.out.println(LazySingleton.getInstance().hashCode());
                System.out.println(LazySingleton.getInstance1().hashCode());
            }).start();
        }
    }
}
