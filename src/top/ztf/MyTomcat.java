package top.ztf;

import top.ztf.servlet.TomcatSocket;

import java.io.IOException;
import java.net.ServerSocket;

public class MyTomcat {

    public static void main(String[] args) {
        // 创建我们的tomcat 然后启动容器
        TomcatSocket tomcatSocket = new TomcatSocket();
        tomcatSocket.run();

    }

}
