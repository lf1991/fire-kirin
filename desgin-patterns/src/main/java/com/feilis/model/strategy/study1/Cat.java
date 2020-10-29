package com.feilis.model.strategy.study1;

/**
 * @ClassName Cat
 * @Description TODO
 * @Author lf199
 * @Date 2020/10/9 11:03
 * @Version V1.0
 */
public class Cat implements Comparable<Cat> {


    private int weight, height;

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }

    Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    @Override
    public int compareTo(Cat o) {
        if (this.weight < o.weight) return -1;
        else if (this.weight > o.weight) return 1;
        else return 0;
    }




    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
