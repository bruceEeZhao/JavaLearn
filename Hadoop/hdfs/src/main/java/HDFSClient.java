import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

import java.io.IOException;

public class HDFSClient {
    public static void main(String[] args) {
        HDFSClient h = new HDFSClient();
        // h.testCopyFromLoaclFile();
        h.testListFiles();
    }

    // 0 一个简单的测试
    public void test() {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://localhost:9091");
        FileSystem fs = null;
        try {
            // 1 获取hdfs客户端对象
            fs = FileSystem.get(conf);

            // 2 在hdfs上创建路径
            fs.mkdirs(new Path("/1109/dashi"));

            // 3 关闭资源
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("over");
    }

    // 1 文件上传
    public void testCopyFromLoaclFile() {
        // 获取fs对象
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://localhost:9091");
        FileSystem fs = null;
        try {
            fs = FileSystem.get(conf);

            // 执行上传api
            fs.copyFromLocalFile(new Path("/home/bruce/Desktop/hadooptest.txt"), new Path("/hadooptest.txt"));

            // 关闭资源
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 2 文件下载
    public void testCopyToLocalFile() {
        // 获取fs对象
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://localhost:9091");
        FileSystem fs = null;
        try {
            fs = FileSystem.get(conf);

            // 执行下载api
            fs.copyToLocalFile(new Path("/hadooptest.txt"), new Path("./hadoop.txt"));
            // 关闭资源
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 3 文件删除
    public void testDelete() {
        // 获取fs对象
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://localhost:9091");
        FileSystem fs = null;
        try {
            fs = FileSystem.get(conf);

            // 执行删除api
            fs.delete(new Path("/hadooptest.txt"));
            // 关闭资源
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 4 查看文件信息
    public void testListFiles() {
        // 获取fs对象
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://localhost:9091");
        FileSystem fs = null;
        try {
            fs = FileSystem.get(conf);

            // 查看文件信息
            RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path("/"), true);
            while (listFiles.hasNext()) {
                LocatedFileStatus fileStatus = listFiles.next();
                System.out.println(fileStatus.getPath().getName());
                System.out.println(fileStatus.getPermission());
                System.out.println(fileStatus.getLen());

                BlockLocation[] blockLocations = fileStatus.getBlockLocations();
                for (BlockLocation block: blockLocations
                     ) {
                    String[] hosts = block.getHosts();

                    for (String host: hosts) {
                        System.out.println(host);
                    }
                }

                System.out.println("====================");
            }

            // 关闭资源
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
