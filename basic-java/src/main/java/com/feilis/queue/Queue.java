package com.feilis.queue;

public interface Queue<T> {
    //队列长度
    int size();

    //是否非空
    boolean isEmpty();

    //添加数据
    int add(T data);

    //返回头元素
    T peek();

    //出队
    T poll();

    //清空队列
    void clear();
}
