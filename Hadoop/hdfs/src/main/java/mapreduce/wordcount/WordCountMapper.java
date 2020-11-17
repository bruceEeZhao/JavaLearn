package mapreduce.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * map阶段
 * KEYIN 输入数据的Key
 * VALUEIN 输入数据的value
 * KEYOUT 输出数据的key， 同时也是Reduce阶段的输入
 * VALUEOUT 输出数据的value， 同时也是Reduce阶段的输入
 */
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    private Text k = new Text();
    private IntWritable v = new IntWritable(1);

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 1 获取一行
        String line = value.toString();
        // 2 切割单词
        String[] words = line.split(" ");
        // 3 循环写出
        for (String word: words) {
            k.set(word);

            context.write(k, v);
        }
    }
}
