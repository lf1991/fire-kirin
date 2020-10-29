package com.feilis.model.chain.somecase1;

/**
 * @ClassName Manager
 * @Description TODO 经理类 职责可以审核10000到50000得金额
 * @Author lf199
 * @Date 2020/10/16 14:30
 * @Version V1.0
 */
public class Manager extends Approver {
    private final static int START = 0;
    private final static int END = 5000;


    @Override
    void hander(int money) {
        if (START <= money && money <= END) System.out.println("Manger handles this request!!");
        else {
            if (this.getNext() == null) {
                System.out.println("no more hadler exist");
                return;
            }
            next.hander(money);
        }
    }
}
