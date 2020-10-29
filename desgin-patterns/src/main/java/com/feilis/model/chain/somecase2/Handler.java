package com.feilis.model.chain.somecase2;

/**
 * @ClassName Handler 抽象处理者
 * @Description TODO
 * @Author lf199
 * @Date 2020/10/20 9:09
 * @Version V1.0
 */
public abstract class Handler {

    protected Handler next;//下一个处理角色

    public abstract void preHandle(); //处置前操作

    public abstract void handle();//处置中

    public abstract void postHandle();//处置后操作


    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }
}
