package mapreduce.outputformat;

import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.yarn.webapp.hamlet.Hamlet;

import java.io.IOException;

public class FRecordWriter extends RecordWriter<Text, NullWritable> {
    FSDataOutputStream fosbaidu;
    FSDataOutputStream fosother;

    public FRecordWriter(TaskAttemptContext job) {
        try {
            // 1 获取文件系统
            FileSystem fs = FileSystem.get(job.getConfiguration());

            // 2 创建输出到baidu.log的输出流
            fosbaidu = fs.create(new Path("/baidu.log"));

            // 3 创建输出到other.log的输出流
            fosother = fs.create(new Path("/other.log"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void write(Text text, NullWritable nullWritable) throws IOException, InterruptedException {
        // 判断key中是否有baidu，如果有，写出到baidu.log否则，写出到other.log

        if (text.toString().contains("baidu")) {
            fosbaidu.write(text.toString().getBytes());
        } else {
            fosother.write(text.toString().getBytes());
        }
    }

    public void close(TaskAttemptContext taskAttemptContext) throws IOException, InterruptedException {
        IOUtils.closeStream(fosbaidu);
        IOUtils.closeStream(fosother);
    }
}
