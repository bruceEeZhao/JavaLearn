package mapreduce.index;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class TwoIndexReducer extends Reducer<Text, Text, Text, Text> {
    Text v = new Text();

    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        StringBuffer tmp = new StringBuffer();
        for (Text value: values
             ) {
            tmp.append(value.toString().replace("\t", "-->")+"\t");
        }

        v.set(tmp.toString());
        context.write(key, v);
    }
}
