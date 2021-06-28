package com.feilis.mapreduce.flowsort;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @ClassName FlowSortReducer
 * @Description TODO
 * @Author lf199
 * @Date 2020/11/9 17:07
 * @Version V1.0
 * <p>
 * K2(FlowBean)  V2(Text)-->K3(Text)  V3(FlowBean)
 */
public class FlowSortReducer extends Reducer<FlowBean, Text, Text, FlowBean> {
    @Override
    protected void reduce(FlowBean key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        for (Text value : values) {
            context.write(value, key);
        }
    }
}
