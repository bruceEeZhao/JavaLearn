import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class HDFSIO {

    public static void main(String[] args) {
        HDFSIO h = new HDFSIO();
        h.testUpLoadFile();
    }

    // 上传文件
    public void testUpLoadFile() {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://localhost:9091");
        FileSystem fs = null;

        try {
            // 1 获取对象
            fs = FileSystem.get(conf);

            // 2 获取输入流
            FileInputStream fis = new FileInputStream(new File("/home/bruce/Desktop/hadooptest.txt"));

            // 3 获取输出流
            FSDataOutputStream fos = fs.create(new Path("/zhangsan.txt"));

            // 4 流的对烤
            IOUtils.copyBytes(fis, fos, conf);

            // 5 关闭资源
            IOUtils.closeStream(fis);
            IOUtils.closeStream(fos);
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // 下载文件
    public void testDownFile() {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://localhost:9091");
        FileSystem fs = null;

        try {
            // 1 获取对象
            fs = FileSystem.get(conf);

            // 2 获取输入流
            FSDataInputStream fis = fs.open(new Path("/zhangsan.txt"));

            // 3 获取输出流
            FileOutputStream fos = new FileOutputStream(new File("./lisi.txt"));

            // 4 流的对烤
            IOUtils.copyBytes(fis, fos, conf);

            // 5 关闭资源
            IOUtils.closeStream(fis);
            IOUtils.closeStream(fos);
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //读取部分内容
    public void readFileSeek() {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://localhost:9091");
        FileSystem fs = null;

        try {
            // 1 获取对象
            fs = FileSystem.get(conf);

            // 2 获取输入流
            FSDataInputStream fis = fs.open(new Path("/zhangsan.txt"));

            // 3 获取输出流
            FileOutputStream fos = new FileOutputStream(new File("./wangwu.txt"));

            // 4 流的对烤
            byte[] bytes = new byte[1024];
            for (int i = 0; i<1 ; i++) {
                int len = fis.read(bytes,0, 5);
                fos.write(bytes,0, 5);
            }

            // 5 关闭资源
            fis.close();
            fos.close();
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //读取部分内容
    public void readFileSeek2() {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://localhost:9091");
        FileSystem fs = null;

        try {
            // 1 获取对象
            fs = FileSystem.get(conf);

            // 2 获取输入流
            FSDataInputStream fis = fs.open(new Path("/zhangsan.txt"));

            // 找到开始的位置
            fis.seek(1024*1024*128);

            // 3 获取输出流
            FileOutputStream fos = new FileOutputStream(new File("./wangwu.txt"));

            // 4 流的对烤
            IOUtils.copyBytes(fis, fos, conf);

            // 5 关闭资源
            fis.close();
            fos.close();
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
