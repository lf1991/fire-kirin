package com.feilis.model.multitcm;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Multion
 * @Description 多例模式，一下子创建有限个同样的类多个，随意使用
 * @Author lf199
 * @Date 2020/9/25 11:23
 * @Version V1.0
 */
public class Multipleton {

    private final static int MAX_COUNT = 4; //最大生成4个实例

    private int num = 0;//当前属于第一个实例

    private static List<Multipleton> instances = new ArrayList<Multipleton>();//实例容器

    private Multipleton(int index) {
        this.num = index;
    }

    static {
        for (int i = 0; i < MAX_COUNT; i++) {
            instances.add(new Multipleton(i));
        }
    }

    public static Multipleton getInstance(int index) {

        if (index > MAX_COUNT) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return instances.get(index);
    }

    public static Multipleton getInstance() {
        int index = (int) (Math.random() * MAX_COUNT);
        return getInstance(index);
    }

    public int getNum() {
        return num;
    }
}
