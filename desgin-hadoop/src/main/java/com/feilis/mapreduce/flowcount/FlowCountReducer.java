package com.feilis.mapreduce.flowcount;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @ClassName FlowCountReducer
 * @Description TODO
 * @Author lf199
 * @Date 2020/11/9 16:17
 * @Version V1.0
 * <p>
 * K2(Text)  v2(FlowBean)--->K3(Text)  V3(FlowBean)
 */
public class FlowCountReducer extends Reducer<Text, FlowBean, Text, FlowBean> {

    @Override
    protected void reduce(Text key, Iterable<FlowBean> values, Context context) throws IOException, InterruptedException {
        //step1. 封装新的FlowBean
        FlowBean flow = new FlowBean();
        Integer upFlow = 0;
        Integer downFlow = 0;
        Integer upCountFlow = 0;
        Integer downCountFlow = 0;
        //step2. 循环计算和
        for (FlowBean value : values) {
            upFlow += value.getUpFlow();
            downFlow += value.getDownFlow();
            upCountFlow += value.getUpCountFlow();
            downCountFlow += value.getDownCountFlow();
        }
        flow.setUpFlow(upFlow);
        flow.setDownFlow(downFlow);
        flow.setUpCountFlow(upCountFlow);
        flow.setDownCountFlow(downCountFlow);
        //step3. 将K3  V3写入上下文中
        context.write(key, flow);
    }
}
