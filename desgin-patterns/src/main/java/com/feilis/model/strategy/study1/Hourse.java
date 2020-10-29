package com.feilis.model.strategy.study1;

/**
 * @ClassName Cat
 * @Description TODO
 * @Author lf199
 * @Date 2020/10/9 11:03
 * @Version V1.0
 */
public class Hourse implements Comparable<Hourse> {

    private int weight;

    Hourse(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Hourse o) {
        if (this.weight < o.weight) return -1;
        else if (this.weight > o.weight) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Hourse{" +
                "weight=" + weight +
                '}';
    }
}
