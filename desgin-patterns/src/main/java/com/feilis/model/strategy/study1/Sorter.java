package com.feilis.model.strategy.study1;

/**
 * @ClassName Sorter
 * @Description TODO
 * @Author lf199
 * @Date 2020/9/30 17:46
 * @Version V1.0
 */
public class Sorter {

    static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j].compareTo(arr[minPos]) == -1 ? j : minPos;
            }
            swap(arr, i, minPos);
        }
    }

    /**
     * 交换方法
     * 〈〉
     *
     * @Param: []
     * @Return: void
     * @Author: lf199
     * @Date: 2020/10/9 9:58
     */
    static void swap(Comparable[] arr, int m, int n) {
        Comparable temp = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;
    }

    /**
     * 功能描述: <br>
     * 〈打印方法〉
     *
     * @Param: [arr]
     * @Return: void
     * @Author: lf199
     * @Date: 2020/10/9 10:59
     */
    static void print(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
