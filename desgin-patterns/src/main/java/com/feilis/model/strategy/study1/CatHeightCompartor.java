package com.feilis.model.strategy.study1;

/**
 * @ClassName CatCompartor
 * @Description TODO  高度比较器
 * @Author lf199
 * @Date 2020/10/9 18:07
 * @Version V1.0
 */
public class CatHeightCompartor implements Compartor<Cat> {
    @Override
    public int compare(Cat o1, Cat o2) {
        if (o1.getHeight() < o2.getHeight()) return -1;
        else if (o1.getHeight() > o2.getHeight()) return 1;
        else return 0;
    }
}
