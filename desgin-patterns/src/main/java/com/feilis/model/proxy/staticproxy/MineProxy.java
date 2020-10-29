package com.feilis.model.proxy.staticproxy;

/**
 * @ClassName MineProxy
 * @Description TODO 代理类
 * @Author lf199
 * @Date 2020/10/20 9:46
 * @Version V1.0
 */
public class MineProxy implements Subject {


    private Subject realSubject;

    @Override
    public void request() {
        preRequest();
        realSubject.request();
        postRequest();
    }

    private void preRequest() {
        System.out.println("前事宜处理......");
    }

    private void postRequest() {
        System.out.println("后事宜处理......");
    }


    public Subject getRealSubject() {
        return realSubject;
    }

    public void setRealSubject(Subject realSubject) {
        this.realSubject = realSubject;
    }
}
