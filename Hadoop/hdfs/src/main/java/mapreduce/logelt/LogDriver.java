package mapreduce.logelt;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class LogDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://localhost:9091");
        // 1 获取Job对象
        Job job = Job.getInstance(conf);

        // 2 设置jar存储位置
        job.setJarByClass(LogDriver.class);

        // 3 关联Map和Reduce类
        job.setMapperClass(LogMapper.class);
        //job.setReducerClass(TableReducer.class);

        // 没有reduce阶段了
//        // 4 设置Mapper阶段输出数据的key，value类型
//        job.setMapOutputKeyClass(Text.class);
//        job.setMapOutputValueClass(TableBean.class);

        // 5 设置最终数据输出的key，value类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);

        // 6 设置输入路径和输出路径
        FileInputFormat.setInputPaths(job, new Path("/logelt"));
        FileOutputFormat.setOutputPath(job, new Path("/output7"));

        // 7 提交job
        job.waitForCompletion(true);
    }
}
