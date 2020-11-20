package mapreduce.join;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;

public class TableMapper extends Mapper<LongWritable, Text, Text, TableBean> {
    String name;
    TableBean bean = new TableBean();

    @Override
    protected void setup(Context context) throws IOException, InterruptedException {

        // 获取文件名称
        FileSplit split = (FileSplit) context.getInputSplit();

        name = split.getPath().getName();
    }

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // id pid amount
        // 1001 01 1

        // pid pname
        // 01 小米
        // 02 华为
        // 03 格力
        Text k = new Text();
        String line = value.toString();
        String[] items = line.split(" ");

        if (name.equals("amount_table")) { // amount
            bean.setId(items[0]);
            bean.setPid(items[1]);
            bean.setAmount(Integer.parseInt(items[2]));
            bean.setPname("");
            bean.setFlag("amount");
            k.set(items[1]);
        } else { // company
            bean.setId("");
            bean.setPid(items[0]);
            bean.setAmount(0);
            bean.setPname(items[1]);
            bean.setFlag("company");
            k.set(items[0]);
        }

        context.write(k, bean);
    }
}
