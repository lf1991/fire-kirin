package com.feilis.mapreduce.reducejoin;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @ClassName ReduceJoinMapper
 * @Description TODO
 * @Author lf199
 * @Date 2020/11/17 18:05
 * @Version V1.0
 */
public class ReduceJoinReducer extends Reducer<Text, Text, Text, Text> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        String first = "", second = "";
        for (Text value : values) {
            if (value.toString().startsWith("p")) first = value.toString();
            else second = value.toString();
        }
        //判空
        if (first.equals("")) context.write(key, new Text("NULL" + "\t" + second));
        else context.write(key, new Text(first + "\t" + second));
    }
}
