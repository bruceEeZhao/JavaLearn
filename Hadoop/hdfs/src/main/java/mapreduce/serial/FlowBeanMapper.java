package mapreduce.serial;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlowBeanMapper extends Mapper<LongWritable, Text, Text, FLowBean> {
    Text k = new Text();
    FLowBean v = new FLowBean();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 获取一行
        String line = value.toString();

        // 切割
        String[] items = line.split(" ");

        // 封装
        k.set(items[0]);
        v.set(Long.parseLong(items[1]), Long.parseLong(items[2]));

        // 写出
        context.write(k, v);
    }
}
