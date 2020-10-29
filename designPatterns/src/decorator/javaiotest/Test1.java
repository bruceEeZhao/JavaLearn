package decorator.javaiotest;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.LineInputStream;

import java.io.*;

public class Test1 {
    public static void main(String[] args) {
        int c;
        try {
            //这里需要使用绝对路径，需要修改一下
            File file = new File("test");
            InputStream stream = new FileInputStream(file);
            stream = new BufferedInputStream(stream);
            stream = new LineInputStream(stream);

            while ((c = stream.read()) >= 0) {
                System.out.print((char) c);
            }

            stream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
