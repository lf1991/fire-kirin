package com.feilis.mapreduce.wordsort;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/**
 * @ClassName JobMain
 * @Description TODO
 * @Author lf199
 * @Date 2020/11/2 13:18
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
        //1.创建Job任务
        Job job = Job.getInstance(super.getConf(), "mapreduce_wordsort");
        //集群运行需要做主类配置
        job.setJarByClass(JobMain.class);

        //2.设置读取文件的类
        job.setInputFormatClass(TextInputFormat.class);
        TextInputFormat.addInputPath(job, new Path("hdfs://hadoop-master:8020/lifei/wordSort.txt"));

        //3.设置mapper类
        job.setMapperClass(WordSortMapper.class);

        //4.设置map阶段输出的类型 k2 和 v2
        job.setMapOutputKeyClass(PairWritable.class);
        job.setMapOutputValueClass(Text.class);

        //5.shuffle阶段===> 分区 排序 规约 分组（采用默认）
        //设置分区对象
        //job.setPartitionerClass(PartitionerOwn.class);

        //6.reduce阶段 设置reducer类别
        job.setReducerClass(WordSortReducer.class);

        //7.设置reduce阶段的类型 k3 和v3
        job.setOutputKeyClass(PairWritable.class);
        job.setOutputValueClass(NullWritable.class);
        //设置reduce的个数
        //job.setNumReduceTasks(2);

        //8.设置输出类和文件输出路径
        job.setOutputFormatClass(TextOutputFormat.class);
        TextOutputFormat.setOutputPath(job, new Path("hdfs://hadoop-master:8020/lifei/wordSort_out"));
        //9. 任务提交等待任务完成状态
        boolean isOK = job.waitForCompletion(true);
        return isOK ? 1 : -1;
    }
}
