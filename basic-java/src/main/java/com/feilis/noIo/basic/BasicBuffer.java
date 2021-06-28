package com.feilis.noIo.basic;

import java.nio.IntBuffer;

/**
 * @ClassName BasicBuffer
 * @Description TODO buffer usage
 * @Author lf199
 * @Date 2021/6/26 23:30
 * @Version V1.0
 */
public class BasicBuffer {


    public static void main(String[] args) {
        BasicBuffer.initIntBUffer();
    }

    static void initIntBUffer() {
        //intBUffer 创建intBuffer 存储5个int
        IntBuffer intBuffer = IntBuffer.allocate(5);
        intBuffer.put(1);
        intBuffer.put(2);
        intBuffer.put(3);
        intBuffer.put(4);
        intBuffer.put(5);

        System.out.println(intBuffer);
        //如何读取值
        //将buffer转换 读写切换--让buffer读写切换（Buffer双向）
        intBuffer.flip();
        intBuffer.position(1);

        while (true) {
            if (intBuffer.hasRemaining())
                System.out.println(intBuffer.get());
            else break;
            ;
        }
    }

}
