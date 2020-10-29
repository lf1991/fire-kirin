package com.feilis.model.strategy.study1;

/**
 * @ClassName CatCompartor
 * @Description TODO
 * @Author lf199
 * @Date 2020/10/9 18:07
 * @Version V1.0
 */
public class CatWeightCompartor implements Compartor<Cat> {
    @Override
    public int compare(Cat o1, Cat o2) {
        if (o1.getWeight() < o2.getWeight()) return -1;
        else if (o1.getWeight() > o2.getWeight()) return 1;
        else return 0;
    }
}
