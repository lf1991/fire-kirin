package com.feilis.model.chain.somecase2;

/**
 * @ClassName Handler1
 * @Description TODO 责任链具体处理角色1
 * @Author lf199
 * @Date 2020/10/20 9:11
 * @Version V1.0
 */
public class Handler2 extends Handler {
    @Override
    public void preHandle() {
        System.out.println("preHandle2——>处理请求前要做的事情......");
    }

    @Override
    public void handle() {
        this.preHandle();
        if (this.next == null) return;
        this.next.handle();
        this.postHandle();
    }

    @Override
    public void postHandle() {
        System.out.println("postHandle2——>处理请求后要做的事情......");
    }
}
