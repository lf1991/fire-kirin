package com.feilis.model.proxy.dynamic.principle;

/**
 * @ClassName Man
 * @Description TODO
 * @Author lf199
 * @Date 2020/10/12 15:25
 * @Version V1.0
 */
public class Man implements IPerson {
    @Override
    public void doWork() {
        System.out.println("男人的好......");
    }
}
