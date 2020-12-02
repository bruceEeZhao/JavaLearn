package mapreduce.compress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.CompressionCodecFactory;
import org.apache.hadoop.io.compress.CompressionInputStream;
import org.apache.hadoop.io.compress.CompressionOutputStream;
import org.apache.hadoop.util.ReflectionUtils;

import java.io.*;

public class TestCompress {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // compress("/home/bruce/Desktop/mapreduce/log", "org.apache.hadoop.io.compress.BZip2Codec");
        // compress("/home/bruce/Desktop/mapreduce/log", "org.apache.hadoop.io.compress.GzipCodec");

        decompress("/home/bruce/Desktop/mapreduce/log.gz");
    }

    private static void decompress(String fileName) throws IOException {
        // 压缩方式检查
        CompressionCodecFactory factory = new CompressionCodecFactory(new Configuration());
        CompressionCodec codec = factory.getCodec(new Path(fileName));

        if (codec == null) {
            System.out.println("can not access");
        }

        // 2 获取输入流
        FileInputStream fis = new FileInputStream(new File(fileName));
        CompressionInputStream cis = codec.createInputStream(fis);

        // 3 获取输出流
        FileOutputStream fos = new FileOutputStream(new File(fileName+".decode"));

        // 4 流的对拷
        IOUtils.copyBytes(cis, fos, 1024*1024, false);

        // 5 关闭资源
        IOUtils.closeStream(fos);
        IOUtils.closeStream(cis);
        IOUtils.closeStream(fis);
    }

    private static void compress(String fileName, String method) throws IOException, ClassNotFoundException {
        // 获取输入流
        FileInputStream fis = new FileInputStream(new File(fileName));

        Class classCodec = Class.forName(method);
        CompressionCodec codec = (CompressionCodec) ReflectionUtils.newInstance(classCodec, new Configuration());


        // 获取输出流
        FileOutputStream fos = new FileOutputStream(new File(fileName+codec.getDefaultExtension()));

        CompressionOutputStream cos = codec.createOutputStream(fos);

        // 流的对拷
        IOUtils.copyBytes(fis, cos, 1024*1024, false);

        // 关闭资源
        IOUtils.closeStream(cos);
        IOUtils.closeStream(fis);
        IOUtils.closeStream(fos);
    }

}
