package mapreduce.serial;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class FlowReducer extends Reducer<Text, FLowBean, Text, FLowBean> {
    private FLowBean fLowBean = new FLowBean();

    @Override
    protected void reduce(Text key, Iterable<FLowBean> values, Context context) throws IOException, InterruptedException {
        long sumup = 0;
        long sumdown = 0;

        // 累加求和
        for (FLowBean v: values
             ) {
            sumup += v.getUp();
            sumdown += v.getDown();
        }

        fLowBean.set(sumup, sumdown);

        // 写出
        context.write(key, fLowBean);
    }
}
