package com.feilis.model.chain.somecase1;

/**
 * @ClassName Client
 * @Description TODO 责任链模式 使用案例  报销审核案例
 * @Author lf199
 * @Date 2020/10/15 12:49
 * @Version V1.0
 */
public class Client {
    public static void main(String[] args) {
        Approver handler = new Manager();
        handler.setNext(new Treasurer());
        handler.hander(800);
    }
}
