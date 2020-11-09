package com.feilis.mapreduce.wordcount;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * @ClassName PartionerOwn
 * @Description TODO hadoop shaffle ——>Partition阶段 分区阶段分区策略
 * @Author lf199
 * @Date 2020/11/5 16:17
 * @Version V1.0
 */
public class PartitionerOwn extends Partitioner<Text, LongWritable> {

    /**
     * 功能描述: <br>
     * 〈〉
     *
     * @Param: [text, longWritable, i]
     * @Return: int
     * @Author: lf199
     * @Date: 2020/11/5 16:20
     * <p>
     * Text：表示 K2
     * longWritable:表示 v2
     * i :reduce的个数
     */
    @Override
    public int getPartition(Text text, LongWritable longWritable, int i) {
        String k2 = text.toString();
        //如果单词的长度大于等于5则提交给第一个分区 否则提交给第二个分区
        if (k2.length() >= 5) {
            return 0; //代表第一个分区
        } else
            return 1;//代表第二个分区
    }
}
