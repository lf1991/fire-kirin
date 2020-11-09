package com.feilis.mapreduce.wordcount;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @ClassName WordCountReducer
 * @Description TODO
 * @Author lf199
 * @Date 2020/11/2 13:19
 * @Version V1.0
 * <p>
 * KEYIN:K2 Text,
 * VALUEIN:V2 LongWritable集合中泛型的类型,
 * KEYOUT:K3 Text,
 * VALUEOUT:V3 LongWritable 每个单词出现的次数
 */
public class WordCountReducer extends Reducer<Text, LongWritable, Text, LongWritable> {

    /**
     * 功能描述: <br>
     * 〈〉
     *
     * @Param: [key, values, context]
     * @Return: void
     * @Author: lf199
     * @Date: 2020/11/2 16:22
     * <p>
     * key:k2 Text每个单词
     * values:单词出现次数的集合
     * context:mapreduce的上下文
     * <p>
     * 将k2和v2转换成k3和v3
     * <p>
     * <p>
     * k2       v2
     * hello    <1,1> 集合
     * hadoop   <1,1>集合
     * <p>
     * ......
     * <p>
     * k3       v3
     * hello     1 所有集合总数
     * hadoop    1 所有集合总数
     */
    @Override
    protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
        long count = 0;
        //1.遍历集合
        for (LongWritable value : values) {
            //2.将集合中的值相加
            count += value.get();
        }
        //3.将k3和v3写入上下文中
        context.write(key,new LongWritable(count));
    }
}
