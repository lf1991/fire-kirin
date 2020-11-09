package com.feilis.mapreduce.wordsort;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @ClassName PairWritable
 * @Description TODO  排序类
 * @Author lf199
 * @Date 2020/11/5 18:01
 * @Version V1.0
 */
public class PairWritable implements WritableComparable<PairWritable> {

    private String first;
    private int second;

    /**
     * 功能描述: <br>
     * 〈实现排序规则〉
     *
     * @Param: [dataOutput]
     * @Return: void
     * @Author: lf199
     * @Date: 2020/11/5 18:03
     */
    @Override
    public int compareTo(PairWritable o) {
        //排序规则 1.先按照first字段排序 2.按照second字段排序
        int res = this.first.compareTo(o.first);
        //如果字符串相同 则按照second来对比
        if (res == 0) {
            return this.second - o.second;
        }
        return res;
    }

    /**
     * 功能描述: <br>
     * 〈实现序列化〉
     *
     * @Param: [dataOutput]
     * @Return: void
     * @Author: lf199
     * @Date: 2020/11/5 18:03
     */
    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(first);
        dataOutput.writeInt(second);
    }

    /**
     * 功能描述: <br>
     * 〈实现反序列化〉
     *
     * @Param: [dataOutput]
     * @Return: void
     * @Author: lf199
     * @Date: 2020/11/5 18:03
     */
    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.first = dataInput.readUTF();
        this.second = dataInput.readInt();
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    /**
     * 功能描述: <br>
     * 〈重写toString 方法〉
     *
     * @Param: []
     * @Return: java.lang.String
     * @Author: lf199
     * @Date: 2020/11/5 18:06
     */
    @Override
    public String toString() {
        return "PairWritable{" +
                "first='" + first + '\'' +
                ", second=" + second +
                '}';
    }
}
