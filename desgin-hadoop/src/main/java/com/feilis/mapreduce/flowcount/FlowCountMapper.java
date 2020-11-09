package com.feilis.mapreduce.flowcount;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @ClassName FlowCountMapper
 * @Description TODO
 * @Author lf199
 * @Date 2020/11/9 16:06
 * @Version V1.0
 * <p>
 * K1(LongWritable)  v1(Text) ---->K2(Text)  V2(FlowBean)
 */
public class FlowCountMapper extends Mapper<LongWritable, Text, Text, FlowBean> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //step1.拆分手机号
        String[] splits = value.toString().split("\t");
        String phoneNum = splits[1];
        //step2.获取流量字段
        FlowBean flow = new FlowBean();
        flow.setUpFlow(Integer.parseInt(splits[6]));
        flow.setDownFlow(Integer.parseInt(splits[7]));
        flow.setUpCountFlow(Integer.parseInt(splits[8]));
        flow.setDownCountFlow(Integer.parseInt(splits[9]));
        //step3将K2  V2写入上下文中
        context.write(new Text(phoneNum), flow);
    }

}
