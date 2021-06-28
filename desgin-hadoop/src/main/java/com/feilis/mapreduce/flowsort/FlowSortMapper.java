package com.feilis.mapreduce.flowsort;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @ClassName FlowSortMapper
 * @Description TODO
 * @Author lf199
 * @Date 2020/11/9 17:01
 * @Version V1.0
 */
public class FlowSortMapper extends Mapper<LongWritable, Text, FlowBean, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //step1.
        FlowBean flow = new FlowBean();
        //step2.
        String[] splits = value.toString().split("\t");
        //step3.获取手机号 作为V2
        String phoneNum = splits[0];
        //step4. 获取其他流量字段 K2
        flow.setUpFlow(Integer.parseInt(splits[1]));
        flow.setDownFlow(Integer.parseInt(splits[2]));
        flow.setUpCountFlow(Integer.parseInt(splits[3]));
        flow.setDownCountFlow(Integer.parseInt(splits[4]));
        //step5 将K2  V2写入上下文
        context.write(flow, new Text(phoneNum));
    }
}
