package multiprocess;

import java.io.*;
import java.util.Arrays;

public class Multiprocess {
    public static void main(String[] args) {
        try {
            ProcessBuilder p = new ProcessBuilder(Arrays.asList("ping", "www.baidu.com"));
            ProcessBuilder p1 = new ProcessBuilder("ping", "www.sina.com");

            Process pp = p.start();
            Process pp1 = p1.start();

            InputStream error = pp.getErrorStream();
            InputStream inputStream = pp.getInputStream();
            OutputStream output = pp.getOutputStream();

            print(error);
            print(inputStream);
            print(pp1.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("==============================");
        System.out.println("main process");
        System.out.println("==============================");
    }
    public static void print(InputStream in) {
        try {
            String encoding = System.getProperty("sun.jnu.encoding");
            InputStreamReader reader = new InputStreamReader(in, encoding);
            BufferedReader bufferedReader = new BufferedReader(reader);
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                System.out.println(line);
                System.out.flush();
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}

