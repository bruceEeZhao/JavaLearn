package mapreduce.order;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

// 000001 Pdt_01 222.8
public class OrderMapper extends Mapper<LongWritable, Text, OrderBean, NullWritable> {
    OrderBean bean = new OrderBean();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 获取一行
        String line = value.toString();

        // 切割
        String[] items = line.split(" ");

        // 为bean赋值
        bean.set(Integer.parseInt(items[0]), Double.parseDouble(items[2]));

        // 写出
        context.write(bean, NullWritable.get());

    }
}
