package com.feilis.mapreduce.wordsort;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
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
public class WordSortReducer extends Reducer<PairWritable, Text, PairWritable, NullWritable> {


    /**
     * 功能描述: <br>
     * 〈将k2 v3转换成k3 v3〉
     *
     * @Param: [key, values, context]
     * @Return: void
     * @Author: lf199
     * @Date: 2020/11/2 16:22
     */
    @Override
    protected void reduce(PairWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        for (Text value : values) {
            context.write(key, NullWritable.get());
        }
    }

}
