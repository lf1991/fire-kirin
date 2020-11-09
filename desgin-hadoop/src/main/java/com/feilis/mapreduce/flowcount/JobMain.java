package com.feilis.mapreduce.flowcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/**
 * @ClassName JobMain
 * @Description TODO 大数据手机流量统计求和
 * @Author lf199
 * @Date 2020/11/9 15:56
 * @Version V1.0
 */
public class JobMain extends Configured implements Tool {
    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration();
        //1.启动任务
        int run = ToolRunner.run(configuration, new JobMain(), args);
        System.exit(run);
    }

    @Override
    public int run(String[] strings) throws Exception {

        //step1.创建主任务
        Job job = Job.getInstance(super.getConf(), "mapreduce_flowcount");
        job.setJarByClass(JobMain.class);

        //step2.设置读取文件类 K1  V1
        job.setInputFormatClass(TextInputFormat.class);
        TextInputFormat.addInputPath(job, new Path("hdfs://hadoop-master:8020/lifei/data_flow.dat"));
        //step3.设置Mapper类
        job.setMapperClass(FlowCountMapper.class);

        //4.设置map阶段输出的类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(FlowBean.class);

        //5.shuffle阶段===> 分区 排序 规约 分组（采用默认）

        //6.reduce阶段 设置reducer类别
        job.setReducerClass(FlowCountReducer.class);
        //7.设置reduce阶段的类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);

        //8.设置输出类和文件输出路径
        job.setOutputFormatClass(TextOutputFormat.class);
        TextOutputFormat.setOutputPath(job, new Path("hdfs://hadoop-master:8020/lifei/flowCount_out"));
        //任务提交等待任务完成状态

        boolean isOK = job.waitForCompletion(true);
        return isOK ? 1 : -1;
    }
}
