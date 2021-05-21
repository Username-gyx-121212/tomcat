package top.ztf.http;

import top.ztf.servlet.HttpServlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

//用于处理请求的
public class RequestHandel implements Runnable{

    private Socket socket;

    public static Map<String,String> mapping = new HashMap<>();

    public RequestHandel(Socket socket) {
        try {
            socket.setSoTimeout(10);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        this.socket = socket;
    }

    @Override
    public void run() {
        HttpServlet httpServlet = new HttpServlet();
        try {
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            Request request = new Request(inputStream);
            Response response = new Response(outputStream);
            httpServlet.service(request,response);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
