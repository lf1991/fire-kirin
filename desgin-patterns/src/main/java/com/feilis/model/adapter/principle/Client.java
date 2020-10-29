package com.feilis.model.adapter.principle;

/**
 * @ClassName Client
 * @Description TODO 适配器模式客户类
 * @Author lf199
 * @Date 2020/10/20 14:18
 * @Version V1.0
 */
public class Client {
    public static void main(String[] args) {
        Target target = new ClassAdapter();
        target.request();
    }
}
