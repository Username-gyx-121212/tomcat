package top.ztf.servlet;

import top.ztf.http.Request;
import top.ztf.http.Response;

public class HttpServlet extends HttpTemplateServlet{


    @Override
    public void doGet(Request request, Response response) {
        //响应数据
        response.writer("你好,tomcat");
    }

    @Override
    public void doPost(Request request, Response response) {

    }
}
