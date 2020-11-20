package mapreduce.outputformat;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class FilterDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://localhost:9091");
        // 1 获取Job对象
        Job job = Job.getInstance(conf);

        // 2 设置jar存储位置
        job.setJarByClass(FilterDriver.class);

        // 3 关联Map和Reduce类
        job.setMapperClass(FilterMapper.class);
        job.setReducerClass(FilterReducer.class);

        // 4 设置Mapper阶段输出数据的key，value类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(NullWritable.class);

        // 5 设置最终数据输出的key，value类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);

        // 关联自定义的输出格式类
        job.setOutputFormatClass(FilterOutputFormat.class);

        // 6 设置输入路径和输出路径
        FileInputFormat.setInputPaths(job, new Path("/log"));

        // 虽然自定义了OutPutFormat，但是因为OutPutFormat继承自FileOutPutFormat
        // 而FileOutPutFormat要输出一个_SUCCESS文件，所以这里还需要指定一个目录。
        FileOutputFormat.setOutputPath(job, new Path("/output"));

        // 7 提交job
        job.waitForCompletion(true);
    }
}
