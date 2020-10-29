package com.feilis.model.singleton;

/**
 * @ClassName SingletonInner
 * @Description 静态内部类单例模式  外部类加载的时候 内部类不会初始化
 * 缺陷 传递参数问题
 * @Author lf199
 * @Date 2020/9/29 11:58
 * @Version V1.0
 */
public class SingletonInner {
     private SingletonInner(){}

     private static  class  SingletonHolder{
         private static SingletonInner INSTANCE=new SingletonInner();
     }

     public static SingletonInner getInstance(){
         return SingletonHolder.INSTANCE;
     }

    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            new Thread(()->{
                System.out.println(SingletonInner.getInstance().hashCode());
            }).start();
        }
    }
}
