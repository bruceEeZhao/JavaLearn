package mapreduce.cache;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.HashMap;

public class DistributedCacheMapper extends Mapper<LongWritable, Text, Text, NullWritable> {

    HashMap<String, String>  cpMap = new HashMap<String, String>();
    Text k = new Text();

    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        // 缓存小表
        URI[] cacheFiles = context.getCacheFiles();
        String path = cacheFiles[0].getPath().toString();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("company_table"), "UTF-8"));

        String line;
        while (StringUtils.isNotEmpty(line = reader.readLine())) {
            // pid pname

            // 1. 切割
            String[] items = line.split(" ");
            cpMap.put(items[0], items[1]);
        }

        IOUtils.closeStream(reader);
    }

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // id pid amount
        // pid pname

        String line = value.toString();
        String[] items = line.split(" ");

        // 获取pid
        String pid = items[1];

        // 从map中取值
        String pidName = cpMap.get(pid);

        // 拼接
        line = line + " " + pidName;
        k.set(line);

        // 写出
        context.write(k, NullWritable.get());
    }
}
