package com.feilis.mapreduce.reducejoin;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;

/**
 * @ClassName ReduceJoinMapper
 * @Description TODO
 * @Author lf199
 * @Date 2020/11/17 18:05
 * @Version V1.0
 */
public class ReduceJoinMapper extends Mapper<LongWritable, Text, Text, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //首先判断数据来自那个文件
        FileSplit fileSplit = (FileSplit) context.getInputSplit();
        String fileName = fileSplit.getPath().getName();
        String[] splits = value.toString().split(",");
        if (fileName.equals("orders.txt")) {
            context.write(new Text(splits[2]), value);
        } else {
            context.write(new Text(splits[0]), value);
        }
    }
}
