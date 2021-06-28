package com.feilis.mapreduce.flowsort;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @ClassName FlowBean
 * @Description TODO 流量bean
 * @Author lf199
 * @Date 2020/11/9 15:58
 * @Version V1.0
 */
public class FlowBean implements WritableComparable<FlowBean> {


    private Integer upFlow; //上行包
    private Integer downFlow; //下行包

    private Integer upCountFlow; //上行流量
    private Integer downCountFlow; //下行流量

    public Integer getUpFlow() {
        return upFlow;
    }

    public void setUpFlow(Integer upFlow) {
        this.upFlow = upFlow;
    }

    public Integer getDownFlow() {
        return downFlow;
    }

    public void setDownFlow(Integer downFlow) {
        this.downFlow = downFlow;
    }

    public Integer getUpCountFlow() {
        return upCountFlow;
    }

    public void setUpCountFlow(Integer upCountFlow) {
        this.upCountFlow = upCountFlow;
    }

    public Integer getDownCountFlow() {
        return downCountFlow;
    }

    public void setDownCountFlow(Integer downCountFlow) {
        this.downCountFlow = downCountFlow;
    }

    @Override
    public String toString() {
        return upFlow +
                "\t" + downFlow +
                "\t" + upCountFlow +
                "\t" + downCountFlow;
    }

    /**
     * 功能描述: <br>
     * 〈实现java bean的序列化〉
     *
     * @Param: [dataOutput]
     * @Return: void
     * @Author: lf199
     * @Date: 2020/11/9 16:03
     */
    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(upFlow);
        dataOutput.writeInt(downFlow);

        dataOutput.writeInt(upCountFlow);
        dataOutput.writeInt(downCountFlow);
    }

    /**
     * 功能描述: <br>
     * 〈实现java bean的反序列化〉
     *
     * @Param: [dataOutput]
     * @Return: void
     * @Author: lf199
     * @Date: 2020/11/9 16:03
     */
    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.upFlow = dataInput.readInt();
        this.downFlow = dataInput.readInt();
        this.upCountFlow = dataInput.readInt();
        this.downCountFlow = dataInput.readInt();
    }

    @Override
    public int compareTo(FlowBean o) {
        //按照手机流量上行数据包排序
        return this.upFlow.compareTo(o.upFlow) * -1;
    }
}
