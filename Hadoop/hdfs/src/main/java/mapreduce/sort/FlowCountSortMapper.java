package mapreduce.sort;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlowCountSortMapper extends Mapper<LongWritable, Text, FlowBean, Text> {
    FlowBean flowBean = new FlowBean();
    Text v = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 1. 获取一行
        String line = value.toString();
        // 2 切割
        String[] items = line.split(" ");
        // 3 封装对象
        String phoneNum = items[0];
        long up = Long.parseLong(items[1]);
        long down = Long.parseLong(items[2]);
        flowBean.set(up, down);

        v.set(phoneNum);

        // 4 写出
        context.write(flowBean, v);
    }
}
