package mapreduce.index;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class TwoIndexMapper extends Mapper<LongWritable, Text, Text, Text> {
    Text k = new Text();
    Text v = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
//        ads--a	3
//        ads--b	2
//        ads--c	1


        // 1 获取一行
        String line = value.toString();

        // 2 切割
        String[] fields = line.split("--");

        k.set(fields[0]);
        v.set(fields[1]);
        context.write(k, v);

    }
}
