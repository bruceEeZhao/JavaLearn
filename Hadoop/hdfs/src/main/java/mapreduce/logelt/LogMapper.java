package mapreduce.logelt;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class LogMapper extends Mapper<LongWritable, Text, Text, NullWritable> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 读取一行
        String line = value.toString();

        // 解析数据
        boolean result = parseLog(line, context);

        if (!result) {
            // 不符合要求，直接返回
            return;
        }

        context.write(value, NullWritable.get());
    }

    private boolean parseLog(String line, Context context) {
        String[] fields = line.split(" ");

        if (fields.length > 11) {
            // 计数器, 为了自定义一些打印输出
            context.getCounter("map", "true").increment(1);
            return true;
        } else {
            // 计数器
            context.getCounter("map", "false").increment(1);
            return false;
        }

    }
}
