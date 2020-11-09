package com.feilis.mapreduce.wordcount;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @ClassName WordCountMapper
 * @Description TODO
 * @Author lf199
 * @Date 2020/11/2 13:18
 * @Version V1.0
 * <p>
 * Mapper==>
 * KEYIN:K1的类型LongWritable,代表行偏移量
 * VALUEIN:V1的类型Text,代表一行文本数据
 * KEYOUT:K2的类型Text,代表每个单词
 * VALUEOUT:V2的类型,固定值1出现的次数
 * <p>
 * hadoop map阶段
 */
public class WordCountMapper extends Mapper<LongWritable, Text, Text, LongWritable> {


    /**
     * 功能描述: <br>
     * 〈将K1和V1转化为K2和V2〉
     *
     * @Param: [key, value, context]
     * @Return: void
     * @Author: lf199
     * @Date: 2020/11/2 13:24
     * <p>
     * <p>
     * key:K1
     * value:V1
     * context:MapReduce的上下文对象(处理流程对象)
     * <p>
     * <p>
     * eg:
     * k1  v1
     * 0   hello world
     * 10  hello hadoop
     * 21  hello hdfs
     * ......
     * <p>
     * 转换为如下:
     * <p>
     * k2      v2
     * hello    1
     * world    1
     * hello    1
     * hadoop   1
     * hello    1
     * hdfs     1
     * ......
     */
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //1.对每一行的数据进行字符串切割拆分
        String line = value.toString();
        String[] words = line.split(" ");
        //2.遍历数组获取每一个单词

        for (String word : words) {
            //step3:将k1转换为k2 v1-->v2 向下传递 至reduce阶段
            context.write(new Text(word), new LongWritable(1));
        }

    }
}
