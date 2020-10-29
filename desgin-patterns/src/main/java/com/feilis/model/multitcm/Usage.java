package com.feilis.model.multitcm;

/**
 * @ClassName Usage
 * @Description 多例使用demo
 * @Author lf199
 * @Date 2020/9/25 11:34
 * @Version V1.0
 */
public class Usage {

    public static void main(String[] args) {
        Multipleton m1 = Multipleton.getInstance();
        System.out.println("index:" + m1.getNum());
        Multipleton m2 = Multipleton.getInstance();
        System.out.println("index:" + m2.getNum());
        Multipleton m3 = Multipleton.getInstance(10);
        System.out.println("index:" + m2.getNum());
    }

}
