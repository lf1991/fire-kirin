package com.feilis.mapreduce.wordsort;

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
public class WordSortMapper extends Mapper<LongWritable, Text, PairWritable, Text> {


    /**
     * 功能描述: <br>
     * 〈将K1和V1转化为K2和V2〉
     * @Param: [key, value, context]
     * @Return: void
     * @Author: lf199
     * @Date: 2020/11/2 13:24
     */
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] strSplits = value.toString().split(" ");
        //封装对象
        PairWritable pairWritable = new PairWritable();
        pairWritable.setFirst(strSplits[0]);
        pairWritable.setSecond(Integer.parseInt(strSplits[1].trim()));
        //将k2和v2写入上下文中
        context.write(pairWritable, value);
    }
}
