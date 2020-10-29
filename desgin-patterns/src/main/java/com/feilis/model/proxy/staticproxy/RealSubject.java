package com.feilis.model.proxy.staticproxy;

/**
 * @ClassName RealSubject
 * @Description TODO 真实处理类
 * @Author lf199
 * @Date 2020/10/20 9:49
 * @Version V1.0
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        doWork();
    }

    private void doWork() {
        System.out.println("我是真实类,我的角色是实际处理事宜......");
    }
}
