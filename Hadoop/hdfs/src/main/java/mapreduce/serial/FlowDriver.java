package mapreduce.serial;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class FlowDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://localhost:9091");
        // 1 获取job
        Job job = Job.getInstance(conf);

        // 2 设置jar路径
        job.setJarByClass(FlowDriver.class);

        // 3 设置mapper和reducer
        job.setMapperClass(FlowBeanMapper.class);
        job.setReducerClass(FlowReducer.class);

        // 4 设置mapper输出类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(FLowBean.class);

        // 5 设置最终输出类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FLowBean.class);

        // 6 设置输入输出路径
        FileInputFormat.setInputPaths(job, new Path("/phonedata"));
        FileOutputFormat.setOutputPath(job, new Path("/output"));
        // 7 提交job
        job.waitForCompletion(true);
    }
}
