package mapreduce.cache;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class DistributedDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException, URISyntaxException {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://localhost:9091");
        // 1 获取Job对象
        Job job = Job.getInstance(conf);

        // 2 设置jar存储位置
        job.setJarByClass(DistributedDriver.class);

        // 3 关联Map和Reduce类
        job.setMapperClass(DistributedCacheMapper.class);
        //job.setReducerClass(TableReducer.class);

        // 没有reduce阶段了
//        // 4 设置Mapper阶段输出数据的key，value类型
//        job.setMapOutputKeyClass(Text.class);
//        job.setMapOutputValueClass(TableBean.class);

        // 5 设置最终数据输出的key，value类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);

        // 加载缓存数据
        job.addCacheFile(new Path("/join/company_table").toUri());
        job.setNumReduceTasks(0);

        // 6 设置输入路径和输出路径
        FileInputFormat.setInputPaths(job, new Path("/join2"));
        FileOutputFormat.setOutputPath(job, new Path("/output6"));

        // 7 提交job
        job.waitForCompletion(true);
    }
}
