package com.feilis.model.strategy.study1;

/**
 * @ClassName StrategyContext
 * @Description TODO
 * @Author lf199
 * @Date 2020/10/9 11:08
 * @Version V1.0
 */
public class StrategyContext {

    private Comparable t;

    public Comparable getT() {
        return t;
    }

    public void setT(Comparable t) {
        this.t = t;
    }

    public void sort(Comparable[] t) {
        Sorter.sort(t);
        Sorter.print(t);
    }

    public <T> void sortT(SorterT sorter, Comparable[] arr, Compartor<T> compartor) {
        sorter.sort(arr, compartor);
        sorter.print(arr);
    }
}
