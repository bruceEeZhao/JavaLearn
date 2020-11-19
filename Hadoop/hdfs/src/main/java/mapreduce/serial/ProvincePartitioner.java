package mapreduce.serial;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class ProvincePartitioner extends Partitioner<Text, FLowBean> {
    public int getPartition(Text text, FLowBean fLowBean, int i) {
        // text是手机号
        // fLowBean 流量信息

        // 获取前3位
        String preNum = text.toString().substring(0,3);

        int partition = 4;

        if ("136".equals(preNum)) {
            partition = 0;
        } else if ("137".equals(preNum)) {
            partition = 1;
        } else if ("138".equals(preNum)) {
            partition = 2;
        } else if ("139".equals(preNum)) {
            partition = 3;
        }

        return partition;
    }
}
