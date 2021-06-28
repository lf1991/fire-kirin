package com.feilis.mapreduce.flowsort;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * @ClassName FlowPartition
 * @Description TODO
 * @Author lf199
 * @Date 2020/11/9 17:35
 * @Version V1.0
 * <p>
 * 手机流量分区类
 * <p>
 * 规则：手机135 开头文件放到一个分区文件
 * 手机136  开头文件放到一个分区文件
 * 手机137  开头文件放到一个分区文件
 * <p>
 * K2(Text)  V2(FlowBean)
 */
public class FlowPartition extends Partitioner<FlowBean,Text> {
    @Override
    public int getPartition( FlowBean flowBean, Text text,int i) {
        String line = text.toString();
        if (line.startsWith("135")) return 0;      //第一个分区
        else if (line.startsWith("136")) return 1; //第一个分区
        else if (line.startsWith("137")) return 2; //第二个分区
        else return 3;                             //第三个分区
    }
}
