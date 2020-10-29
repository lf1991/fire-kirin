package com.feilis.model.strategy.study1;

/**
 * @ClassName Cat
 * @Description TODO
 * @Author lf199
 * @Date 2020/10/9 11:03
 * @Version V1.0
 */
public class Elephant implements Comparable<Elephant> {


    private int weight;

    Elephant(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Elephant o) {
        if (this.weight < o.weight) return -1;
        else if (this.weight > o.weight) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Elephant{" +
                "weight=" + weight +
                '}';
    }

}
