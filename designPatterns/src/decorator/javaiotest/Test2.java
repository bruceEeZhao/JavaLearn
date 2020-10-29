package decorator.javaiotest;

import java.io.*;

public class Test2 {
    public static void main(String[] args) {
        int c;
        try {
            //这里需要使用绝对路径，需要修改一下
            InputStream in = new LowerCaseInputStream(
                    new BufferedInputStream(
                            new FileInputStream("test")));

            while ((c = in.read()) >= 0) {
                System.out.print((char)c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
