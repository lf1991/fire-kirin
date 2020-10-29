package com.feilis.model.chain.principle;

/**
 * @ClassName Handler
 * @Description TODO 责任链抽象处理者模式
 * @Author lf199
 * @Date 2020/10/15 11:58
 * @Version V1.0
 */
public abstract class Handler {

    private Handler next;//持有下一个处理者对象 意在下一步处理

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }

    /**
     * 功能描述: <br>
     * 〈〉抽象处理方法
     *
     * @Param: [request]
     * @Return: void
     * @Author: lf199
     * @Date: 2020/10/15 12:37
     */
    public abstract void handler(String request);
}
