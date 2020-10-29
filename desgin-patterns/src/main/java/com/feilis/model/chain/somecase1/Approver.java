package com.feilis.model.chain.somecase1;

/**
 * @ClassName Approver  抽象审批类
 * @Description TODO
 * @Author lf199
 * @Date 2020/10/15 13:08
 * @Version V1.0
 */
public abstract class Approver {


    protected Approver next;

    abstract void hander(int money);

    public Approver getNext() {
        return next;
    }

    public void setNext(Approver next) {
        this.next = next;
    }
}
