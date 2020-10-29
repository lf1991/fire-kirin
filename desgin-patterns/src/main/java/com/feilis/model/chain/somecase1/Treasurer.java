package com.feilis.model.chain.somecase1;

/**
 * @ClassName Treasurer 财务类
 * @Description TODO
 * @Author lf199
 * @Date 2020/10/19 9:41
 * @Version V1.0
 */
public class Treasurer extends Approver {

    private final static int START = 5000;
    private final static int END = 10000;

    @Override
    void hander(int money) {
        if (START <= money && money <= END) System.out.println("Treasurer handles this request!!");
        else {
            if (this.getNext() == null) {
                System.out.println("no more hadler exist");
                return;
            }
            next.hander(money);
        }
    }
}
