package com.feilis.model.strategy.study1;

/**
 * @ClassName Client
 * @Description TODO
 * @Author lf199
 * @Date 2020/10/9 11:10
 * @Version V1.0
 */
public class Client {
    public static void main(String[] args) {
        StrategyContext context = new StrategyContext();
        Cat[] cats = {new Cat(12, 12), new Cat(13, 13), new Cat(8, 8)};
        // context.sort(ca
        // Hourse[] hourses = {new Hourse(12), new Hourse(13), new Hourse(8)};
        // context.sort(hours
        // Elephant[] elephants = {new Elephant(12), new Elephant(13), new Elephant(8)};
        // context.sort(elephants);
        SorterT<Cat> sorter = new SorterT<Cat>();
        //context.sortT(sorter,cats,new CatWeightCompartor());
        context.sortT(sorter, cats, new CatHeightCompartor());
    }
}
