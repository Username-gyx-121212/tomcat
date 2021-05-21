package top.ztf.servlet;


import top.ztf.http.RequestHandel;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 主要负责容器->监听socket 请求连接,,并且执行处理方法
 */
public class TomcatSocket {

    public int port = 8080;

    public void run(){
        try {
            ServerSocket socket = new ServerSocket(port);
            while (true){
                Socket accept = socket.accept();
                // 有人进行连接,开启一个线程进行处理
                RequestHandel requestHandel = new RequestHandel(accept);
                new Thread(requestHandel).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
