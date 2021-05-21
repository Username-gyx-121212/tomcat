package top.ztf;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class SocketDemo {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true){
            Socket accept = socket.accept();
            new Thread(()->{
                InputStream is=null;
                OutputStream out = null;

                try {
                    // 设置超时时间
                    System.out.println(accept.getSoTimeout());
                    accept.setSoTimeout(10);

                    is = accept.getInputStream();
                    byte[] bytes = new byte[1000];
                    int len = -1;

                    try {
                        while ((len=is.read(bytes))!=-1){
                            String s = new String(bytes, 0, len);
                            System.out.println(s);

                        }
                    }catch (Exception e){
                        // 这里一定有异常,连接超时
                        //e.printStackTrace();
                    }
                    out = accept.getOutputStream();
                    out.write("HTTP/1.1 200 OK\n".getBytes());
                    out.write("Content-Type:text/html;charset:GBK\n".getBytes());
                    out.write("\n".getBytes());
                    out.write("ok\n".getBytes());
//                    printStream.println("HTTP/1.1 200 OK");
//                    printStream.println("Content-Type:text/html;charset:GBK");
//                    printStream.println();
                    //printStream.flush();
                    //printStream.close();
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println("关闭连接");
                    try {
                        is.close();
                        //accept.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }).start();
        }
    }

    public static void closAll(Closeable... closeables){
        for (Closeable closeable : closeables) {
            if (closeable!=null){
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
